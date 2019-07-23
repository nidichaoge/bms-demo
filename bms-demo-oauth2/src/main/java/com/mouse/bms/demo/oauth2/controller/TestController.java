package com.mouse.bms.demo.oauth2.controller;

import com.mouse.bms.demo.oauth2.dao.UserDAO;
import com.mouse.bms.demo.oauth2.dataobject.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-17 20:12
 * @description
 */
@RestController
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Resource
    private UserDAO userDAO;
//    @Resource
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @PostMapping("/user/save")
//    public Long saveUser(@RequestBody User user) {
//        String encode = bCryptPasswordEncoder.encode(user.getPassword());
//        LOGGER.info("password:{}, encode:{}.", user.getPassword(), encode);
//        return userDAO.save(user.getUsername(), encode);
//    }

    //role
    @PreAuthorize("hasRole('user')")
    @GetMapping("/test")
    public String test(String name) {
        LOGGER.info("test function.");
        return "hello " + name;
    }

    //等同于user
    @PreAuthorize("hasRole('ROLE_user')")
    @GetMapping("/test7")
    public String test7(String name) {
        LOGGER.info("test7 function.");
        return "hello " + name;
    }

    @GetMapping("/hi")
    public String hi(String name) {
        return "hi , " + name;
    }

}
