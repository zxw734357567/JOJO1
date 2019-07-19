package com.example.demo.configurations.securityConfig.jwtTokenFilter.extractor;

/**
 *  Implementations of this interface should always return raw base-64 encoded
 * representation of JWT Token.
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/4/29  11:24.
 * @Modified by:
 */
public interface TokenExtractor {
     String extract(String payload);
}
