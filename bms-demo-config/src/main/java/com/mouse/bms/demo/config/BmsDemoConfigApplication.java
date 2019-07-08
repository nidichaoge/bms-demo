package com.mouse.bms.demo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class BmsDemoConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmsDemoConfigApplication.class, args);
    }

}
