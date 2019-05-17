package com.example.demo.configurations.rabbitMq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/5/17  16:27.
 * @Modified by:
 */
@Configuration
public class RabbitMqConfig {
    @Bean
    public Queue queue(){
        return new Queue("hello");
    }
}
