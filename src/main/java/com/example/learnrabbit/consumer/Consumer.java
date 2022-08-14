package com.example.learnrabbit.consumer;

import com.example.learnrabbit.config.ConsumerConfig;
import com.example.learnrabbit.config.MqConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Consumer {
//    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(MqConfig.class);
//        AmqpTemplate amqpTemplate = context.getBean(AmqpTemplate.class);
//        System.out.println("Received: " + amqpTemplate.receiveAndConvert());
//    }

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(ConsumerConfig.class);
    }
}
