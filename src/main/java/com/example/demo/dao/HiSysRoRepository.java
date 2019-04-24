package com.example.demo.dao;

import com.example.demo.entity.HiSysRoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/4/24  13:24.
 * @Modified by:
 */
public interface HiSysRoRepository extends JpaRepository<HiSysRoEntity,String> {
    HiSysRoRepository findByIdRo(String idRo);
}
