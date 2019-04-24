package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2019-4-12.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u left join fetch u.roles r where u.username=:username")
    public Optional<User> findByUsername(@Param("username") String username);
}
