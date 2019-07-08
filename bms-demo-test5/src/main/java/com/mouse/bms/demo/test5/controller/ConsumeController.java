package com.mouse.bms.demo.test5.controller;

import com.mouse.bms.demo.test5.dto.User;
import com.mouse.bms.demo.test5.service.ConsumeService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/consume")
    public String consume() {
        return consumeService.hello();
    }

    @GetMapping("/get")
    public User get(@RequestParam Long id) {
        return consumeService.get(id);
    }

    @PostMapping("/post")
    public Boolean post(@RequestBody User user) {
        return consumeService.post(user);
    }

    @PutMapping("/put")
    public Long put(@RequestBody User user) {
        return consumeService.put(user);
    }

    @DeleteMapping("/delete")
    public Boolean delete(@RequestParam Long id) {
        return consumeService.delete(id);
    }

}
