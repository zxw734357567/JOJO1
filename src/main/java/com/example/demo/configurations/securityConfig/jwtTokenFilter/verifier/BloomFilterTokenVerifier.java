package com.example.demo.configurations.securityConfig.jwtTokenFilter.verifier;

import org.springframework.stereotype.Component;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/4/29  13:31.
 * @Modified by:
 */
@Component
public class BloomFilterTokenVerifier implements  TokenVerifier  {
    @Override
    public boolean verify(String jti) {
        return true;
    }
}
