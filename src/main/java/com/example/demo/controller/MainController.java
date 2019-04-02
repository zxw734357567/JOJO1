package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019-3-28.
 */
@RequestMapping("/test")
@RestController
@Api(tags="测试",description = "描述我的测试")
@ApiModel("用户实体")
public class MainController {
    //测试
    @ApiOperation("描述我的接口")
    @GetMapping(value = "/sd")
    public String main(){
        return "你进来了!";
    }

}
