package com.example.demo.service;

import com.example.demo.entity.JojoUser;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/5/6  9:55.
 * @Modified by:
 */
public interface UserService {
    Boolean  saveOne(JojoUser jojoUser);
    JojoUser findByUsername(String username);
}
