package com.mouse.bms.demo.test7.rabbit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-10 23:23
 * @description
 */
@Component
public class RabbitSender {

    @Resource
    private AmqpTemplate amqpTemplate;

    public void send() throws JsonProcessingException {
        User mouse = User.builder().name("mouse").age(23).build();
//        ObjectMapper objectMapper = new ObjectMapper();
//        String s = objectMapper.writeValueAsString(mouse);
        amqpTemplate.convertAndSend("hello",mouse);
    }

    public static void main(String[] args) throws JsonProcessingException {
        User mouse = User.builder().name("mouse").age(23).build();
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(mouse);
        System.out.println(s);
    }
}
