package com.mouse.bms.demo.test7.rabbit;

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

    public void send() {
        User mouse = User.builder().name("mouse").age(23).build();
        amqpTemplate.convertAndSend("hello", mouse);
    }

}
