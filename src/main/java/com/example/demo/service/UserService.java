package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.Optional;

/**
 * Created by Administrator on 2019-4-21.
 */
public interface UserService {
    public Optional<User> getByUsername(String username);
}
