package com.mouse.bms.demo.testa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-17 20:12
 * @description security支持注解的方式，也支持config配置类的方式
 * 使用注解时,需参考TestSecurityConfig
 * 经测试发现,当一个用户同时拥有role和authority时,访问只需要hasRole的方法失败，但是可以访问带有hasAuthority的方法
 * 原理参考这个:rg.springframework.security.core.userdetails.jdbc.JdbcDaoImpl
 */
@RestController
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    //role
    @PreAuthorize("hasRole('user')")
    @GetMapping("/test")
    public String test(String name) {
        LOGGER.info("test function.");
        return "hello " + name;
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/test2")
    public String test2(String name) {
        LOGGER.info("test2 function.");
        return "hello " + name;
    }

    //auth mouse
    @PreAuthorize("hasAuthority('a')")
    @GetMapping("/test3")
    public String test3(String name) {
        LOGGER.info("test3 function.");
        return "hello " + name;
    }

    //chao
    @PreAuthorize("hasAuthority('b')")
    @GetMapping("/test4")
    public String test4(String name) {
        LOGGER.info("test4 function.");
        return "hello " + name;
    }

    //role
    @PreAuthorize("hasAnyRole('user') or hasAnyRole('admin')")
    @GetMapping("/test5")
    public String test5(String name) {
        LOGGER.info("test5 function.");
        return "hello " + name;
    }

    //auth mouse chao
    @PreAuthorize("hasAuthority('a') or hasAnyAuthority('b')")
    @GetMapping("/test6")
    public String test6(String name) {
        LOGGER.info("test6 function.");
        return "hello " + name;
    }

    //等同于user
    @PreAuthorize("hasRole('ROLE_user')")
    @GetMapping("/test7")
    public String test7(String name) {
        LOGGER.info("test7 function.");
        return "hello " + name;
    }

}
