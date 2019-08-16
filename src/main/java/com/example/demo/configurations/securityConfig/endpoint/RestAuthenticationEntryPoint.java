package com.example.demo.configurations.securityConfig.endpoint;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/4/29  14:54.
 * @Modified by:
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    /**
     *@Description  直接返回不能够
     *@Param [request, response, ex]
     *@Return void
     *@Author zhangxw
     *@Date 2019/8/14
     *@Time 10:58
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException ex)
            throws IOException, ServletException {
        response.sendError(HttpStatus.UNAUTHORIZED.value(), "Unauthorized");
    }
}
