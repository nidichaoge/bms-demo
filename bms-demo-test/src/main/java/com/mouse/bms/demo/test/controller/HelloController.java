package com.mouse.bms.demo.test.controller;

import com.mouse.bms.demo.test.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-07 15:42
 * @description
 */
@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String hello() {
        LOGGER.info("hello function");
        return "hello";
    }

    @GetMapping("/get")
    public UserDTO get(@RequestParam Long id) {
        LOGGER.info("get function.id:{}.", id);
        return UserDTO.builder().id(id).name("mouse").age(23).build();
    }

    @PostMapping(value = "/post")
    public Boolean post(@RequestBody UserDTO userDTO) {
        LOGGER.info("post function.userDTO:{}", userDTO);
        return Boolean.TRUE;
    }

    @PutMapping("/put")
    public Long put(@RequestBody UserDTO userDTO) {
        LOGGER.info("put function.userDTO:{}", userDTO);
        return userDTO.getId();
    }


    @DeleteMapping("/delete")
    public Boolean delete(@RequestParam Long id) {
        LOGGER.info("delete function.id:{}.", id);
        return Boolean.TRUE;
    }

}
