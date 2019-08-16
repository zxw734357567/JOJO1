package com.example.demo.controller.User;


import com.example.demo.Dto.UserTree;
import com.example.demo.common.TreeStructureUtil;
import com.example.demo.configurations.securityConfig.entities.JojoUser;
import com.example.demo.configurations.securityConfig.service.UserService;
import com.example.demo.entity.HttpCode;
import com.example.demo.entity.ResultEntity;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/userTree")
@RestController
@Api(value = "用户树结构", tags = "用户")
public class UserTreeOperation {

    @Resource
    private UserService userService;

    @PostMapping(value = "all")
    @ApiOperation(value = "查询所有的节点的信息", notes = "一次性查询所有的节点")
    public ResultEntity<List<UserTree>> getAllTreeNodes() {
        List<UserTree> trees = new ArrayList<>();
        List<JojoUser> allUser = userService.getAllTreeNodes();
        if (allUser == null || allUser.isEmpty()) {
            ResultEntity<List<UserTree>> reponse = new ResultEntity<List<UserTree>>(HttpCode.OK, "树结构为空!");
            return reponse;
        }
        for (JojoUser item : allUser) {
            UserTree userTreeNode = new UserTree();
            BeanUtils.copyProperties(item, userTreeNode);
            trees.add(userTreeNode);
        }
        //所有的节点,我设置所有的节点为初始节点
        List<UserTree> tree = TreeStructureUtil.getTree(trees, null);
        ResultEntity<List<UserTree>> reponse = new ResultEntity<List<UserTree>>(HttpCode.OK, "查询成功!", tree);
        return reponse;
    }


    @PostMapping(value = "newOne")
    @ApiOperation(value = "新增一个节点", notes = "通过父节点查询一个新的子节点")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pid", value = "父节点", required = true, paramType = "query", dataType = "Long")
    })
    /**
     *@Description
     *@Param [username, password]
     *@Return com.example.demo.entity.ResultEntity<java.util.com.example.demo.Dto.UserTree>>
     *@Author zhangxw
     *@Date 2019/8/13
     *@Time 10:03
     */
    public ResultEntity<List<UserTree>> addTreeNode(String username, String password, Long pid) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password) || (pid == null)) {
            ResultEntity<List<UserTree>> reponse = new ResultEntity<List<UserTree>>(HttpCode.OK, "用户名,pid或密码不能为空!");
            return reponse;
        }
        JojoUser jojoUser = new JojoUser();
        //将密码加密加盐
        String hashpw = BCrypt.hashpw(password, BCrypt.gensalt());
        jojoUser.setUsername(username);
        jojoUser.setPassword(hashpw);
        jojoUser.setPid(pid);
        userService.saveTreeNode(jojoUser);
        ResultEntity<List<UserTree>> reponse = new ResultEntity<List<UserTree>>(HttpCode.OK, "保存成功!");
        return reponse;
    }

}
