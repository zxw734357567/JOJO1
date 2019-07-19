package com.example.demo.configurations.securityConfig.endpoint;


import com.example.demo.configurations.securityConfig.jwtTokenFilter.JwtAuthenticationToken;
import com.example.demo.configurations.securityConfig.model.UserContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/4/29  16:00.
 * @Modified by:
 */
@RestController
public class ProfileEndpoint {
    @RequestMapping(value="/api/me", method= RequestMethod.GET)
    public @ResponseBody
    UserContext get(JwtAuthenticationToken token) {
        return (UserContext) token.getPrincipal();
    }
}
