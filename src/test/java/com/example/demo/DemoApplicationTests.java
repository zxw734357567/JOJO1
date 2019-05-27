package com.example.demo;

import com.example.demo.Dto.RolesAndPermissionInUser;
import com.example.demo.dao.JojoUserRepository;
import com.example.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


	@Autowired
    JojoUserRepository jojoUserRepository;
	@Transactional
	@Test
	public void contextLoads() {

	}

}
