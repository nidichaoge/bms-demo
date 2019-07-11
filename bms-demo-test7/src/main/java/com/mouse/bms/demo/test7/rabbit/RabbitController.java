package com.mouse.bms.demo.test7.rabbit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-10 23:36
 * @description
 */
@RestController
public class RabbitController {

    @Resource
    private RabbitSender rabbitSender;

    @GetMapping("/send")
    public String send() {
        rabbitSender.send();
        return "ok";
    }

}
