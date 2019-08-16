package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/3/29  15:05.
 * @Modified by:
 */
@Controller
@RequestMapping("/api/user")
@Api(tags = "登录", description = "使用JWT完成登录")
public class LoginController {
    //Note:在SpringSecurity模块的时候,会跳转到该页面,因为任何请求都会被拦截,有的文件必须被放开
    @RequestMapping(value="/login")
    @ApiOperation("用户用用户名和密码等了页面")
    public String loginPage(){
        return "pages/login";
    }
}
