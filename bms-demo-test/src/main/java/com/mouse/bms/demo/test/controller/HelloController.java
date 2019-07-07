package com.mouse.bms.demo.test.controller;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-07 15:42
 * @description
 */
@RestController
public class HelloController {

//    @Resource
//    DiscoveryClient discoveryClient;
    @GetMapping("/hello")
    public String hello() {
//        System.out.println(discoveryClient);
        System.out.println("hello");
        return "hello";
    }
}
