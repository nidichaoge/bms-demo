package com.mouse.bms.demo.test9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.time.Duration;
import java.time.Instant;

@EnableDiscoveryClient
@SpringBootApplication
public class BmsDemoTest9Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(BmsDemoTest9Application.class);

    public static void main(String[] args) {
        Instant start = Instant.now();
        SpringApplication.run(BmsDemoTest9Application.class, args);
        Instant end = Instant.now();
        Duration between = Duration.between(start, end);
        LOGGER.info("test9 started successfully. Take {} seconds.", between.getSeconds());
    }

}
