package com.example.demo.configurations.securityConfig.dao;

import com.example.demo.configurations.securityConfig.entities.JojoUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Administrator on 2019-4-12.
 */
public interface JojoUserRepository extends JpaRepository<JojoUser, Long> {

     Optional<JojoUser> findByUsername(String username);


}
