package com.example.demo.RedisTest;

import com.example.demo.common.RedisUtil;
import com.example.demo.entity.HiSysRoEntity;
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

    //普通的保存
    @Test
    public void save() {
        redisUtil.set("李一一","123");
    }
    //普通的获取
    @Test
    public void get() {
        String value = (String) redisUtil.get("李一一");
        HiSysRoEntity value1 = (HiSysRoEntity) redisUtil.get("HiSysRoEntity:1");
        System.out.println(value);
        System.out.println(value1);
    }
    //将实体转化为
    @Test
    public void saveEntityToJson(){
        HiSysRoEntity hiSysRoEntity=new HiSysRoEntity();
        hiSysRoEntity.setCd("123");
        hiSysRoEntity.setDes("快乐");
        boolean set = redisUtil.set("HiSysRoEntity:1", hiSysRoEntity);
        HiSysRoEntity o =(HiSysRoEntity) redisUtil.get("HiSysRoEntity:1");
        System.out.println(o.toString());
    }
}
