package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019-3-28.
 */
@RestController
public class MainController {
    //测试
    @RequestMapping(value = "/sd")
    public String main(){
        return "你进来了!";
    }

}
