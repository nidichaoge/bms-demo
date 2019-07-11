package com.mouse.bms.demo.test7.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-10 23:26
 * @description
 */
@Component

public class RabbitReceiver {

    @RabbitHandler
    @RabbitListener(queues = {"hello"})
    public void process(User user){
        System.out.println("RabbitReceiver: "+user);
    }

}
