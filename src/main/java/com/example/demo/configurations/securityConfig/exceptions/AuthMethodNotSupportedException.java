package com.example.demo.configurations.securityConfig.exceptions;

import org.springframework.security.authentication.AuthenticationServiceException;

/**
 * Created by Administrator on 2019-4-21.
 */
public class AuthMethodNotSupportedException extends AuthenticationServiceException {
    public AuthMethodNotSupportedException(String msg) {
        super(msg);
    }
}