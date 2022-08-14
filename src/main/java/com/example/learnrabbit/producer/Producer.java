package com.example.learnrabbit.producer;

import com.example.learnrabbit.config.MqConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Producer {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MqConfig.class);
        AmqpTemplate amqpTemplate = context.getBean(AmqpTemplate.class);
        amqpTemplate.convertAndSend("Hello World");
        System.out.println("Sent: Hello World");
    }
}
