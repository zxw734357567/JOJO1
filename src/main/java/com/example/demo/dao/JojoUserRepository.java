package com.example.demo.dao;

import com.example.demo.Dto.RolesAndPermissionInUser;
import com.example.demo.entity.JojoUser;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2019-4-12.
 */
public interface JojoUserRepository extends JpaRepository<JojoUser, Long> {

     @Transactional
     Optional<JojoUser> findByUsername( String username);

     @Transactional
     @Query(value = "select new com.example.demo.Dto.RolesAndPermissionInUser( jju.id,  jju.username, jju. password, jjp. url,  jjr.id) from JojoUser jju left join " +
             " JojoRoleUser jjru on jju.id=jjru.sysUserId left join JojoRole jjr on jjru.sysRoleId=jjr.id left join" +
             " JojoPermissionRole jjpr on jjpr.roleId=jjr.id left join JojoPermission jjp on  jjpr.permissionId=jjp.id where jju.id=?1")
     List<RolesAndPermissionInUser> findRolesAndPermissionByUsernameByID(Long id);
}
