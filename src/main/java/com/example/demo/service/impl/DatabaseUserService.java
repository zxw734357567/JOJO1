package com.example.demo.service.impl;

import com.example.demo.Dto.RolesAndPermissionInUser;
import com.example.demo.dao.JojoUserRepository;
import com.example.demo.entity.JojoUser;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2019-4-21.
 */
@Service
public class DatabaseUserService implements UserService{
    private final JojoUserRepository jojoUserRepository;
   /* private final JojoRoleUserRepository jojoRoleUserRepository;
    private final JojoRoleRepository jojoRoleRepository;*/
    @Autowired
    public DatabaseUserService(JojoUserRepository jojoUserRepository) {
        this.jojoUserRepository = jojoUserRepository;

    }

    @Override
    public Optional<JojoUser> findByUsername(String username) {
        return this.jojoUserRepository.findByUsername(username);
    }

    @Override
    public List<RolesAndPermissionInUser> findRolesAndPermissionByUsernameByID(Long id) {
        return this.jojoUserRepository.findRolesAndPermissionByUsernameByID(id);
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
