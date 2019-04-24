package com.example.demo.JpaRepositoryTest;

import com.example.demo.dao.HiSysRoRepository;
import com.example.demo.entity.HiSysRoEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/4/24  13:25.
 * @Modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HiSysRoRepositoryTest {
    @Autowired
    HiSysRoRepository hiSysRoRepository;
    //查询所有
    @Transactional(readOnly = true)
    @Test
    public void get(){
        List<HiSysRoEntity> all = hiSysRoRepository.findAll();
        all.forEach(System.out::print);
    }
    //查询通过Id ,如果不加事务的话,会造成session丢失
    @Transactional(readOnly = true)
    @Test
    public void getByIdRo(){
        HiSysRoEntity one = hiSysRoRepository.getOne("5b1f4ddebfc19d39646d2749");
        System.out.println(one.toString());
    }
}
