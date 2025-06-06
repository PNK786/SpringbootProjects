package com.Rabbitmq.Springboot.publisher;

import com.Rabbitmq.Springboot.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer
{
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitmqProducer.class);
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    private RabbitTemplate rabbitTemplate;

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(User user)
    {
        LOGGER.info(String.format("json message ->%s",user.toString()));
        rabbitTemplate.convertAndSend(exchange,routingJsonKey,user);
    }
}
