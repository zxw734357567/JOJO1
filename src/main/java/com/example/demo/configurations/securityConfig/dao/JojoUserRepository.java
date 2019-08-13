package com.example.demo.configurations.securityConfig.dao;

import com.example.demo.configurations.securityConfig.entities.JojoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * Created by Administrator on 2019-4-12.
 */
public interface JojoUserRepository extends JpaRepository<JojoUser, Long> {

     Optional<JojoUser> findByUsername(String username);

     @Query("update JojoUser set path= ?1 where id = ?2")
     @Modifying
     void updateJojoUser(String path,Long id);


}
