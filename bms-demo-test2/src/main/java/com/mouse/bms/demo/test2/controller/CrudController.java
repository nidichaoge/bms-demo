package com.mouse.bms.demo.test2.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mouse.bms.demo.test2.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-08 18:02
 * @description
 */
@RestController
public class CrudController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CrudController.class);
    private static final String URL = "http://bms-demo-test/";
    @Resource
    private RestTemplate restTemplate;

    /**
     * User可以只关注自己关注的属性
     * get请求，response是实体类
     *
     * @param id
     * @return
     */
    @GetMapping("/get")
    public String get(@RequestParam Long id) {
        User body = restTemplate.getForEntity(URL + "get?id=" + id, User.class).getBody();
        LOGGER.info("{}", body);
        return "get";
    }

    /**
     * post请求
     *
     * @param user
     * @return
     */
    @PostMapping("/post")
    public String post(@RequestBody User user) {
        Boolean body = restTemplate.postForEntity(URL + "post", user, Boolean.class).getBody();
        LOGGER.info("{}", body);
        return "post";
    }

    /**
     * put请求
     *
     * @param user
     * @return
     */
    @PutMapping("/put")
    public String put(@RequestBody User user) {
        restTemplate.put(URL + "put", user);
        LOGGER.info("put");
        return "put";
    }

    /**
     * delete请求
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id) {
        restTemplate.delete(URL + "delete?id=" + id);
        LOGGER.info("delete");
        return "delete";
    }

}
