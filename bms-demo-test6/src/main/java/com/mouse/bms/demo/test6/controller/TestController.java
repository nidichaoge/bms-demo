package com.mouse.bms.demo.test6.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-09 13:08
 * @description
 */
//@RefreshScope
@RestController
public class TestController {

    @Value("${from}")
    private String from;

    @Resource
    private Environment environment;

    @GetMapping("/from")
    public String test(){
        return this.from;
    }

    @GetMapping("/from2")
    public String test2(){
        return environment.getProperty("from","undefined");
    }

}
