package com.example.demo.JpaRepositoryTest;

import com.example.demo.dao.HiSysRoRepository;
import com.example.demo.dao.JojoAuthorRepository;
import com.example.demo.dao.JojoUserRepository;
import com.example.demo.entity.HiSysRoEntity;
import com.example.demo.entity.JojoAuthor;
import com.example.demo.entity.JojoUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired
    JojoUserRepository jojoUserRepository;
    @Autowired
    JojoAuthorRepository jojoAuthorRepository;

    //查询所有
    @Transactional(readOnly = true)
    @Test
    public void get() {
        List<HiSysRoEntity> all = hiSysRoRepository.findAll();
        List<JojoUser> all1 = jojoUserRepository.findAll();
        all1.forEach(System.out::print);
    }

    //查询通过Id ,如果不加事务的话,会造成session丢失
    @Transactional(readOnly = true)
    @Test
    public void getByIdRo() {
        HiSysRoEntity one = hiSysRoRepository.getOne("5b1f4ddebfc19d39646d2749");
        System.out.println(one.toString());
    }

    @Transactional(readOnly = true)
    @Test
    public void findUserOfRoleAndPermissionByUserName() {
        Optional<JojoUser> user = jojoUserRepository.findByUsername("zhangsan");

    }

    @Transactional(readOnly = true)
    @Test
    public void findById() {
        //List<JojoAuthor> all = jojoAuthorRepository.findAll();
        Optional<JojoAuthor> byId = jojoAuthorRepository.findById("1");
        System.out.println(byId.get());
    }

    @Transactional(readOnly = true)
    @Test
    public void findAll() {
        List<JojoAuthor> all = jojoAuthorRepository.findAll();

        all.forEach(System.out::print);
    }

    /**
     * @param
     * @return
     * @Author: Zhangxw
     * @Description:左迫切外连接
     * @Date 15:54  2019/5/16
     */
    @Transactional(readOnly = true)
    @Test
    public void findAllByFetch() {
        List<JojoAuthor> jojoAuthors = jojoAuthorRepository.queryForFetch();
        jojoAuthors.forEach(System.out::print);

    }




}
