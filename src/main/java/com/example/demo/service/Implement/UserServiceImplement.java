package com.example.demo.service.Implement;

import com.example.demo.dao.JojoUserRepository;
import com.example.demo.entity.JojoUser;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/5/6  9:57.
 * @Modified by:
 */
@Service
public class UserServiceImplement implements UserService {

    @Autowired
    JojoUserRepository jojoUserRepository;

    @Override
    public JojoUser saveOne(JojoUser jojoUser) {
        JojoUser save = jojoUserRepository.save(jojoUser);
        return save;
    }

    @Override
    public JojoUser findByUsername(String username) {
        Optional<JojoUser> byUsername = jojoUserRepository.findByUsername(username);
        if (byUsername.isPresent()) {
            return byUsername.get();
        }
        return null;
    }
}
