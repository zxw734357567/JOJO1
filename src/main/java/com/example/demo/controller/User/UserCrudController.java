package com.example.demo.controller.User;

import com.example.demo.entity.JojoUser;
import com.example.demo.entity.ResultEntity;
import com.example.demo.service.Implement.UserServiceImplement;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/5/6  9:51.
 * @Modified by:
 */
@RestController()
@RequestMapping("/user")
public class UserCrudController {

    @Autowired
    UserServiceImplement userServiceImplement;


    @RequestMapping(value = "/save",method = RequestMethod.POST ,produces = "application/json")
    @ResponseBody
    public ResultEntity<JojoUser> save(@RequestBody() JojoUser jojoUser){
        if(jojoUser==null || StringUtils.isBlank(jojoUser.getUsername()) || StringUtils.isBlank(jojoUser.getPassword())){
            //传入的参数校验,为空的话,是返回状态码,还是
            return new ResultEntity<JojoUser>(200,"用户名或密码为空!");
        }
        //查询用户是否存在,如果不存在就返回,
        JojoUser byUsername = userServiceImplement.findByUsername(jojoUser.getUsername());

        return  new ResultEntity<JojoUser>(200,byUsername);
        //查不出来,保存用户
    }
}
