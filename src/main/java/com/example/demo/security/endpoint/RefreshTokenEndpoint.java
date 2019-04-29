package com.example.demo.security.endpoint;

import com.example.demo.security.config.ApplicationSecurity;
import com.example.demo.entity.JojoPermission;
import com.example.demo.entity.JojoRoleUser;
import com.example.demo.entity.JojoUser;
import com.example.demo.security.auth.jwt.extractor.TokenExtractor;
import com.example.demo.security.auth.jwt.verifier.TokenVerifier;
import com.example.demo.security.config.JwtSettings;
import com.example.demo.security.exceptions.InvalidJwtToken;
import com.example.demo.security.model.UserContext;
import com.example.demo.security.model.token.JwtToken;
import com.example.demo.security.model.token.JwtTokenFactory;
import com.example.demo.security.model.token.RawAccessJwtToken;
import com.example.demo.security.model.token.RefreshToken;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 *  * RefreshTokenEndpoint
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/4/29  13:35.
 * @Modified by:
 */
@RestController
public class RefreshTokenEndpoint {
    @Autowired private JwtTokenFactory tokenFactory;
    @Autowired private JwtSettings jwtSettings;
    @Autowired
    private UserService userService;
    @Autowired private TokenVerifier tokenVerifier;
    @Autowired @Qualifier("jwtHeaderTokenExtractor") private TokenExtractor tokenExtractor;

    @RequestMapping(value="/api/auth/token", method= RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody
    JwtToken refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String tokenPayload = tokenExtractor.extract(request.getHeader(ApplicationSecurity.AUTHENTICATION_HEADER_NAME));

        RawAccessJwtToken rawToken = new RawAccessJwtToken(tokenPayload);
        RefreshToken refreshToken = RefreshToken.create(rawToken, jwtSettings.getTokenSigningKey()).orElseThrow(() -> new InvalidJwtToken());

        String jti = refreshToken.getJti();
        if (!tokenVerifier.verify(jti)) {
            throw new InvalidJwtToken();
        }

        String subject = refreshToken.getSubject();
        JojoUser user = userService.findByUsername(subject).orElseThrow(() -> new UsernameNotFoundException("User not found: " + subject));

        List<JojoRoleUser> bySysUserId = userService.findBySysUserId(user.getId());

        List<JojoPermission> permissionsByRoleId = userService.findPermissionsByRoleId(bySysUserId);
        if (bySysUserId == null) {throw new InsufficientAuthenticationException("User has no roles assigned");}
        List<GrantedAuthority> authorities = permissionsByRoleId.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getUrl()))
                .collect(Collectors.toList());

        UserContext userContext = UserContext.create(user.getUsername(), authorities);

        return tokenFactory.createAccessJwtToken(userContext);
    }
}
