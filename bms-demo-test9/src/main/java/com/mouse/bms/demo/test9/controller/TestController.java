package com.mouse.bms.demo.test9.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-17 13:12
 * @description
 */
@RestController
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/hi")
    public String test(@RequestParam String name) {
        LOGGER.info("test function.");
        return "hello" + name;
    }

}
