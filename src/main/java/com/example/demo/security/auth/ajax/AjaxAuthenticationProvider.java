package com.example.demo.security.auth.ajax;

import com.example.demo.Dto.RolesAndPermissionInUser;
import com.example.demo.entity.JojoPermission;
import com.example.demo.entity.JojoRoleUser;
import com.example.demo.entity.JojoUser;
import com.example.demo.entity.User;
import com.example.demo.security.auth.model.UserContext;
import com.example.demo.service.impl.DatabaseUserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019-4-21.
 */
public class AjaxAuthenticationProvider implements AuthenticationProvider {

    private final BCryptPasswordEncoder encoder;
    private final DatabaseUserService userService;

    public AjaxAuthenticationProvider(final DatabaseUserService userService, final BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
        this.userService = userService;
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Assert.notNull(authentication, "No authentication data provided");

        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        JojoUser user = userService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        if (!encoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Authentication Failed. Username or Password not valid.");
        }
        List<JojoRoleUser> bySysUserId = userService.findBySysUserId(user.getId());

        if (bySysUserId == null) {throw new InsufficientAuthenticationException("User has no roles assigned");}

        List<JojoPermission> permissionsByRoleId = userService.findPermissionsByRoleId(bySysUserId);
        List<GrantedAuthority> authorities = permissionsByRoleId.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getUrl()))
                .collect(Collectors.toList());
        UserContext userContext = UserContext.create(user.getUsername(), authorities);
        return new UsernamePasswordAuthenticationToken(userContext, null, userContext.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
