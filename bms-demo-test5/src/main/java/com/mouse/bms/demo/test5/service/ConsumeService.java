package com.mouse.bms.demo.test5.service;

import com.mouse.bms.demo.test5.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-07 22:16
 * @description 入参和返回值必须一样
 * <p>
 * fallback指定的类是降级类
 */

@FeignClient(value = "bms-demo-test", fallback = ConsumeServiceFallback.class)
public interface ConsumeService {

    @GetMapping("/hello")
    String hello();

    @GetMapping("/get")
    User get(@RequestParam Long id);

    @PostMapping("/post")
    Boolean post(@RequestBody User user);

    @PutMapping("/put")
    Long put(@RequestBody User user);

    @DeleteMapping("/delete")
    Boolean delete(@RequestParam Long id);

}
