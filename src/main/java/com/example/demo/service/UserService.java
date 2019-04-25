package com.example.demo.service;

import com.example.demo.Dto.RolesAndPermissionInUser;
import com.example.demo.entity.JojoRole;
import com.example.demo.entity.JojoRoleUser;
import com.example.demo.entity.JojoUser;

import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2019-4-21.
 */
public interface UserService {
     Optional<JojoUser> findByUsername(String username);
    List<RolesAndPermissionInUser> findRolesAndPermissionByUsernameByID(Long id);
}
