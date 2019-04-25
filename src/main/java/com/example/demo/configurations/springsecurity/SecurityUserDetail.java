package com.example.demo.configurations.springsecurity;

import com.example.demo.dao.JojoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019-4-2.
 */
@Component
public class SecurityUserDetail implements UserDetailsService {
    @Autowired
    private JojoUserRepository jojoUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
   /*     List<User> byUserName = userRepository.findByUserName(s);*/

        //userRepository.findAll()
        return null;
    }
}
