package com.mouse.bms.demo.test8.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-07 16:06
 * @description
 */
@RestController
public class ConsumeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumeController.class);

    @Resource
    private RestTemplate restTemplate;

    /**
     * 被调用方bms-demo-test的请求处可以打印出traceId和spanId,此处为null
     *
     * @return
     */
    @GetMapping("/consume")
    public String consume(HttpServletRequest request) {
        LOGGER.info("consume,traceId:{},spanId:{}.",request.getHeader("X-B3-TraceId"),request.getHeader("X-B3-SpanId"));
        return restTemplate.getForEntity("http://bms-demo-test/hello", String.class).getBody();
    }

}
