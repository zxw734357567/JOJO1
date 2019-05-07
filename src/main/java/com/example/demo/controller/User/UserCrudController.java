package com.example.demo.controller.User;

import com.example.demo.entity.HttpCode;
import com.example.demo.entity.JojoUser;
import com.example.demo.entity.ResultEntity;
import com.example.demo.service.Implement.UserServiceImplement;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags="用户",description = "对用户的相关操作")
public class UserCrudController {

    @Autowired
    UserServiceImplement userServiceImplement;


    @RequestMapping(value = "/save",method = RequestMethod.POST ,produces = "application/json")
    @ResponseBody
    @ApiOperation("新增一个用户")
    public ResultEntity<JojoUser> save(@RequestBody() JojoUser jojoUser){
        if(jojoUser==null || StringUtils.isBlank(jojoUser.getUsername()) || StringUtils.isBlank(jojoUser.getPassword())){
            //传入的参数校验,为空的话,是返回状态码,还是
            return new ResultEntity<JojoUser>(HttpCode.BAD_REQUEST,"用户名或密码为空!");
        }
        //查询用户是否存在,如果不存在就返回,
        Boolean byUsername = userServiceImplement.saveOne(jojoUser);

       return  !byUsername?new ResultEntity<JojoUser>(HttpCode.BAD_REQUEST,byUsername+"用户名存在!"):new ResultEntity<JojoUser>(HttpCode.OK,"新增成功!");

    }

   @GetMapping(value = "/{username}",produces = "application/json")
    @ApiOperation("查询用户名是否存在!,加入了缓存")
    public ResultEntity<JojoUser> findByUsername( @PathVariable String username){
        if(username==null || StringUtils.isBlank(username) ){
            //传入的参数校验,为空的话,是返回状态码,还是
            return new ResultEntity<JojoUser>(HttpCode.BAD_REQUEST,"用户名为空!");
        }
        //查询用户是否存在,如果不存在就返回,
       JojoUser byUsername = userServiceImplement.findByUsername(username);

    return   byUsername==null?new ResultEntity<JojoUser>(HttpCode.BAD_REQUEST,byUsername+"用户名不存在!"):new ResultEntity<JojoUser>(HttpCode.OK,byUsername+"用户名存在!");


    }

}
