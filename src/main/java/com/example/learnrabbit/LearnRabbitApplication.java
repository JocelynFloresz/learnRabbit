package com.example.learnrabbit;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class LearnRabbitApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("rabbitConfiguration.xml");
        AmqpAdmin amqpAdmin = context.getBean(AmqpAdmin.class);
        Queue helloWorldQueue = new Queue("hello.world.queue");
        Exchange exchange = new DirectExchange("MyExchange");
        amqpAdmin.declareQueue(helloWorldQueue);
        amqpAdmin.declareExchange(exchange);
    }

}
