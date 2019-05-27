package com.example.demo.configurations.rabbitMq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.ConsumerTagStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/5/17  16:27.
 * @Modified by:
 */
@Configuration
public class RabbitMqConfig {
    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses("127.0.0.1:5672");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        return connectionFactory;
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        rabbitAdmin.setAutoStartup(true);
        return rabbitAdmin;
    }


    
    /**
    * @Author: Zhangxw
    * @Description:一个队列
    * @Date 15:50  2019/5/23
    * @param 
    * @return 
    */
    @Bean
    public Queue queueHello(){
        return new Queue("hello");
    }

    /**
    * @Author: Zhangxw
    * @Description: 一个路由器
    * @Date 15:49  2019/5/23
    * @param 
    * @return 
    */
    @Bean
    public TopicExchange exchange002() {
        return new TopicExchange("topic002", true, false);
    }
    /**
    * @Author: Zhangxw
    * @Description:
    * @Date 15:49  2019/5/23
    * @param 
    * @return 
    */
    @Bean
    public Binding binding002() {
        return BindingBuilder.bind(queueHello()).to(exchange002()).with("rabbit.*");
    }

    /**
    * @Author: Zhangxw
    * @Description:RabbitMq模板
    * @Date 16:01  2019/5/23
    * @param 
    * @return 
    */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        return rabbitTemplate;
    }


    /**
    * @Author: Zhangxw
    * @Description:消费者监听
    * @Date 15:55  2019/5/23
    * @param 
    * @return 
    */
    @Bean
    public SimpleMessageListenerContainer messageContainer(ConnectionFactory connectionFactory) {

        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        //可同时监控多个队列
        container.setQueues(queueHello());

        container.setConcurrentConsumers(1);
        //最多多少个消费者
        container.setMaxConcurrentConsumers(5);
        container.setDefaultRequeueRejected(false);
        //自动签收
        container.setAcknowledgeMode(AcknowledgeMode.AUTO);
        //消费端标签策略
        container.setExposeListenerChannel(true);
        container.setConsumerTagStrategy(new ConsumerTagStrategy() {
            @Override
            public String createConsumerTag(String queue) {
                return queue + "_" + UUID.randomUUID().toString();
            }
        });
        // 具体监听
        container.setMessageListener(new ChannelAwareMessageListener() {
            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                String msg = new String(message.getBody());
                System.err.println("----------消费者: " + msg);
            }
        });
        return container;
    }


}
