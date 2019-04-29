package com.example.demo.Dto;

import com.example.demo.entity.JojoPermission;
import com.example.demo.entity.JojoRole;
import com.example.demo.entity.JojoUser;

import java.util.Set;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/4/28  19:49.
 * @Modified by:
 */
public class UserOfRoleAndPermissonDto extends JojoUser{
    private Set<JojoRole> userRoles;
    private Set<JojoPermission> userPermission;

    public Set<JojoRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<JojoRole> userRoles) {
        this.userRoles = userRoles;
    }

    public Set<JojoPermission> getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(Set<JojoPermission> userPermission) {
        this.userPermission = userPermission;
    }
}
