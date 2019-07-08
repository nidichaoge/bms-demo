package com.mouse.bms.demo.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.time.Duration;
import java.time.Instant;

@EnableEurekaClient
@SpringBootApplication
public class BmsDemoTestApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(BmsDemoTestApplication.class);

    public static void main(String[] args) {
        Instant start = Instant.now();
        SpringApplication.run(BmsDemoTestApplication.class, args);
        Instant end = Instant.now();
        Duration between = Duration.between(start, end);
        LOGGER.info("eureka client started successfully. Take {} seconds.", between.getSeconds());
    }

}
