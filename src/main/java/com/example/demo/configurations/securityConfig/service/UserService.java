package com.example.demo.configurations.securityConfig.service;


import com.example.demo.configurations.securityConfig.entities.JojoPermission;
import com.example.demo.configurations.securityConfig.entities.JojoRoleUser;
import com.example.demo.configurations.securityConfig.entities.JojoUser;

import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2019-4-21.
 */
public interface UserService {
     Optional<JojoUser> findByUsername(String username);
    List<JojoRoleUser> findBySysUserId(Long sysUserId);
    List<JojoPermission> findPermissionsByRoleId(List<JojoRoleUser> jojoRoleUsers);

  /*  List<RolesAndPermissionInUser> findUserOfRoleAndPermissionByUserName(String username);*/
}
