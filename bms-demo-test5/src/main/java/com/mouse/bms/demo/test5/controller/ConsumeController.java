package com.mouse.bms.demo.test5.controller;

import com.mouse.bms.demo.test5.service.ConsumeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-07 22:18
 * @description
 */
@RestController
public class ConsumeController {

    @Resource
    private ConsumeService consumeService;

    @GetMapping("/hello")
    public String consume(){
        return consumeService.hello();
    }

}
