package com.example.demo.security.auth.ajax;

import com.example.demo.entity.User;
import com.example.demo.service.impl.DatabaseUserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
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

    public AjaxAuthenticationProvider( DatabaseUserService userService,BCryptPasswordEncoder encoder){
        this.encoder = encoder;
        this.userService = userService;
    }

    private final DatabaseUserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Assert.notNull(authentication, "No authentication data provided");

        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        User user = userService.getByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        if (!encoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Authentication Failed. Username or Password not valid.");
        }

        if (user.getRoles() == null) throw new InsufficientAuthenticationException("User has no roles assigned");

      /*  List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getRole().authority()))
                .collect(Collectors.toList());*/

        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
