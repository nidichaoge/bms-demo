package com.mouse.bms.demo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class BmsDemoConfigApplication {

    /**
     *                              /名字           /环境/分支
     * 访问地址 http://127.0.0.1:8000/bms-demo-test6/test/master
     * 从git获取到信息后，会存储在本地的应用文件系统中
     */
    public static void main(String[] args) {
        SpringApplication.run(BmsDemoConfigApplication.class, args);
    }

}
