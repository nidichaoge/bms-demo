package com.mouse.bms.demo.test7.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-10 23:34
 * @description
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue(){
        return new Queue("hello");
    }

}
