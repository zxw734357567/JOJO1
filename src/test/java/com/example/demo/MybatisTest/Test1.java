package com.example.demo.MybatisTest;

import com.example.demo.dao.mybatisDao.JojoAuthorMapper;
import com.example.demo.entity.mybatisEntity.JojoAuthor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/5/20  10:33.
 * @Modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1 {

    @Autowired
    JojoAuthorMapper jojoAuthorMapper;

    @Test
    public void query(){
        JojoAuthor jojoAuthor = jojoAuthorMapper.selectByPrimaryKey("1");
        System.out.println(jojoAuthor);
    }

    /**
    * @Author: Zhangxw
    * @Description: 混合使用where,bind,if标签对于单表的操作,基本完成除了时间格式的操作
    * @Date 16:00  2019/5/20
    * @param 
    * @return 
    */
    @Test
    public void selectByNameAndAge(){
        List<JojoAuthor> jojoAuthors = jojoAuthorMapper.selectByNameAndAge(null,null);
        jojoAuthors.forEach(System.out::print);
    }

    /**
    * @Author: Zhangxw
    * @Description:可以使用map作为resultMap
    * @Date 13:47  2019/5/21
    * @param 
    * @return 
    */
    @Test
    @Transactional()
    public void selectByJojoAuthorEntity(){
        JojoAuthor jojoAuthor=new JojoAuthor();
        jojoAuthor.setAge(new BigDecimal(12));
        HashMap<String, Object> stringObjectHashMap = jojoAuthorMapper.selectByJojoAuthorEntity(jojoAuthor);
        for (Map.Entry<String,Object> entry:stringObjectHashMap.entrySet()){
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key+"--------------------"+value);
        }
    }
}
