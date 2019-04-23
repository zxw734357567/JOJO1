package com.example.demo.RedisTest;

import com.example.demo.RedisRepository.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/4/23  15:52.
 * @Modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisCRUD {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void save() {
        redisUtil.set("李一一","123");
    }
    @Test
    public void get() {
        String value = (String) redisUtil.get("李一一");
        System.out.println(value);
    }
}
