package com.example.learnrabbit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerConsumer {

    @RabbitListener(queues = "MyQueue")
    @RabbitHandler
    public void handleMessage2(String string) {
        System.out.println(string);
    }
}
