package com.example.demo.Dto;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/5/17  16:41.
 * @Modified by:
 */
@Component
@RabbitListener(queues = "*.orange")
public class RabbitAccept {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver  :1111111111111111111111111111111111111111111111111111111111111111 " + hello);
    }
}
