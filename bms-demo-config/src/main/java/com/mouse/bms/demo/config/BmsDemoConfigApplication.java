package com.mouse.bms.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

import java.time.Duration;
import java.time.Instant;

@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class BmsDemoConfigApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(BmsDemoConfigApplication.class);

    /**
     *                              /名字           /环境/分支
     * 访问地址 http://127.0.0.1:8000/bms-demo-test6/test/master
     * 从git获取到信息后，会存储在本地的应用文件系统中
     * 分支如果带有/在访问地址时用_替换
     */
    public static void main(String[] args) {
        Instant start = Instant.now();
        SpringApplication.run(BmsDemoConfigApplication.class, args);
        Instant end = Instant.now();
        Duration between = Duration.between(start, end);
        LOGGER.info("config server started successfully. Take {} seconds.", between.getSeconds());
    }

}
