package com.mouse.bms.demo.test5.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-07 22:16
 * @description
 */
@FeignClient(name = "BMS-DEMO-TEST",value = "BMS-DEMO-TEST")
public interface ConsumeService {

    @GetMapping("/hello")
    String hello();

}
