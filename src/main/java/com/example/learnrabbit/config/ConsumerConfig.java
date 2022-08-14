package com.example.learnrabbit.config;

import com.example.learnrabbit.Handler.HelloWorldHandler;
import com.example.learnrabbit.consumer.ListenerConsumer;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig extends MqConfig {

    @Bean
    public SimpleMessageListenerContainer listenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setQueueNames("MyQueue");
        container.setMessageListener(mqConfigAdapter());
//        container.setMessageListener(new MessageListenerAdapter(new HelloWorldHandler()));
        return container;
    }

    @Bean
    public MessageListenerAdapter mqConfigAdapter() {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(new ListenerConsumer());
        messageListenerAdapter.setDefaultListenerMethod("handleMessage2");
        return  messageListenerAdapter;
    }
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setConcurrentConsumers(3);
        factory.setMaxConcurrentConsumers(10);
//        factory.setContainerCustomizer(container -> /* customize the container */);
        return factory;
    }
}
