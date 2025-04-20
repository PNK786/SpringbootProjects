package com.Rabbitmq.Springboot.publisher;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitmqProducer
{
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    /*@Value("${rabbitmq.queue.name}")
    private String name;*/

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitmqProducer.class);

    @Value("${rabbitmq.routing.key}")
    private String routingkey;

    private RabbitTemplate rabbitTemplate;

    public RabbitmqProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public  void sendMessage(String message)
    {
        LOGGER.info(String.format("Message sent ->  %s",message));

        rabbitTemplate.convertAndSend(exchange,routingkey,message);
    }
}
