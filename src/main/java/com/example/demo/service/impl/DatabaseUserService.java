package com.example.demo.service.impl;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Administrator on 2019-4-21.
 */
@Service
public class DatabaseUserService implements UserService{
    private final UserRepository userRepository;

    @Autowired
    public DatabaseUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }
}
