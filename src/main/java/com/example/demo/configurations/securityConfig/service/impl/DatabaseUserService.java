package com.example.demo.configurations.securityConfig.service.impl;


import com.example.demo.configurations.securityConfig.dao.*;
import com.example.demo.configurations.securityConfig.entities.JojoPermission;
import com.example.demo.configurations.securityConfig.entities.JojoPermissionRole;
import com.example.demo.configurations.securityConfig.entities.JojoRoleUser;
import com.example.demo.configurations.securityConfig.entities.JojoUser;
import com.example.demo.configurations.securityConfig.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2019-4-21.
 */
@Service

public class DatabaseUserService implements UserService {

    @Autowired
    private EntityManager entityManager;

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
    @Transactional
    public Optional<JojoUser> findByUsername(String username) {
        return this.jojoUserRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public List<JojoPermission> findPermissionsByRoleId(List<JojoRoleUser> jojoRoleUsers) {
        List<JojoPermission> jojoPermissionsList = new ArrayList<>();
        for (JojoRoleUser jojoRoleUserItem : jojoRoleUsers) {
            List<JojoPermissionRole> byRoleId = jojoPermissionRoleRepository.findByRoleId(jojoRoleUserItem.getSysRoleId());
            for (JojoPermissionRole item : byRoleId) {
                JojoPermission one = jojoPermissionRepository.getOne(item.getRoleId());
                jojoPermissionsList.add(one);
            }
        }

        return jojoPermissionsList;
    }

    /**
     * 返回所有的节点
     *
     * @return
     */
    @Transactional
    @Override
    public List<JojoUser> getAllTreeNodes() {
        List<JojoUser> all = jojoUserRepository.findAll();
        return all;
    }



    @Override
    @Transactional
    /**
    *@Description 保存节点
    *@Param [jojoUser]
    *@Return com.example.demo.configurations.securityConfig.entities.JojoUser
    *@Author zhangxw
    *@Date 2019/8/13
    *@Time 10:07
    */
    public JojoUser saveTreeNode(JojoUser jojoUser) {
        //先保存 ,初始的值为0/
        JojoUser save = jojoUserRepository.save(jojoUser);
        JojoUser one = jojoUserRepository.getOne(save.getPid());
        String path = one.getPath();
        String substring = path.substring(0, path.lastIndexOf("/"));
        //截取字符串
        long id = save.getId();
        //将字符串合并
        String newPath = substring + "/" + id;
        jojoUserRepository.updateJojoUser(newPath, id);
        return save;
    }

    @Override
    @Transactional
    public List<JojoRoleUser> findBySysUserId(Long sysUserId) {
        return jojoRoleUserRepository.findBySysUserId(sysUserId);
    }


 /**
 *@Description 
 *@Param * @param null
 *@Return 
 *@Author zhangxw
 *@Date 
 *@Time 17:52
 */
    @Transactional
    public List<JojoUser> findByNameOrPath(String name, String path) {
        StringBuilder sb = new StringBuilder();
        List<JojoUser> result = new ArrayList<>();
        sb.append("select * from jojo_user where 1=1  ");
        if (StringUtils.isNotBlank(name)) {
            sb.append("and username like :username ");
        }
        if (StringUtils.isNotBlank(path)) {
            sb.append("and path like :path ");
        }
        Query nativeQuery = entityManager.createNativeQuery(sb.toString());
        if (StringUtils.isNotBlank(name)) {
            nativeQuery.setParameter("username", "%"+name);
        }
        if (StringUtils.isNotBlank(path)) {
            nativeQuery.setParameter("path", "%"+path);
        }
        return nativeQuery.getResultList();

    }


}
