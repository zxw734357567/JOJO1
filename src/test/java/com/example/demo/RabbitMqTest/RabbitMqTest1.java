package com.example.demo.RabbitMqTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/5/17  16:30.
 * @Modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest1 {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send(){
        amqpTemplate.convertAndSend("sed.orange","hello world");
    }


}
