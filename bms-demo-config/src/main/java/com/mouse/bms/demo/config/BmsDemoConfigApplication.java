package com.mouse.bms.demo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class BmsDemoConfigApplication {

    /**
     *                              /     /环境 /分支
     * 访问地址 http://127.0.0.1:8000/mouse/prod/master
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(BmsDemoConfigApplication.class, args);
    }

}
