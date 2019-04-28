package com.example.demo.service.impl;

import com.example.demo.Dto.RolesAndPermissionInUser;
import com.example.demo.dao.*;
import com.example.demo.entity.JojoPermission;
import com.example.demo.entity.JojoPermissionRole;
import com.example.demo.entity.JojoRoleUser;
import com.example.demo.entity.JojoUser;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2019-4-21.
 */
@Service
public class DatabaseUserService implements UserService{
    private final JojoUserRepository jojoUserRepository;
    private final JojoRoleUserRepository jojoRoleUserRepository;
    private final JojoRoleRepository jojoRoleRepository;
    private final JojoPermissionRepository jojoPermissionRepository;
    private final JojoPermissionRoleRepository jojoPermissionRoleRepository;

    @Autowired
    public DatabaseUserService(JojoUserRepository jojoUserRepository, JojoRoleUserRepository jojoRoleUserRepository, JojoRoleRepository jojoRoleRepository,
                               JojoPermissionRepository jojoPermissionRepository, JojoPermissionRoleRepository jojoPermissionRoleRepository) {
        this.jojoUserRepository = jojoUserRepository;
        this.jojoRoleUserRepository = jojoRoleUserRepository;
        this.jojoRoleRepository = jojoRoleRepository;
        this.jojoPermissionRepository = jojoPermissionRepository;
        this.jojoPermissionRoleRepository = jojoPermissionRoleRepository;
    }

    @Override
    public Optional<JojoUser> findByUsername(String username) {
        return this.jojoUserRepository.findByUsername(username);
    }

    @Override
    public List<RolesAndPermissionInUser> findRolesAndPermissionByUsernameByID(Long id) {
        return this.jojoUserRepository.findRolesAndPermissionByUsernameByID(id);
    }

    @Override
    public List<JojoRoleUser> findBySysUserId(Long sysUserId) {
        return jojoRoleUserRepository.findBySysUserId(sysUserId);
    }

    @Override
    public List<JojoPermission> findPermissionsByRoleId( List<JojoRoleUser> jojoRoleUsers) {
        List<JojoPermission> jojoPermissionsList=new ArrayList<>();
        for (JojoRoleUser jojoRoleUserItem:jojoRoleUsers) {
            List<JojoPermissionRole> byRoleId = jojoPermissionRoleRepository.findByRoleId(jojoRoleUserItem.getSysRoleId());
            for (JojoPermissionRole item:byRoleId ) {
                JojoPermission one = jojoPermissionRepository.getOne(item.getRoleId());
                jojoPermissionsList.add(one);
            }
        }

        return jojoPermissionsList;
    }




 /*   @Override
    public List<JojoRoleUser> findBySysUserId(Long sysUserId) {
        return this.jojoRoleUserRepository.findBySysUserId(sysUserId);
    }

    @Override
    public JojoRole findByName(Long id) {
        return null;
    }*/


}
