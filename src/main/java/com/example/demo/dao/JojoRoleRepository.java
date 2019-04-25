package com.example.demo.dao;

import com.example.demo.Dto.RolesAndPermissionInUser;
import com.example.demo.entity.JojoRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2019-4-24.
 */
public interface JojoRoleRepository extends JpaRepository<JojoRole,Long> {


}
