package com.mouse.bms.demo.test3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

import java.time.Duration;
import java.time.Instant;

@EnableTurbine
@EnableDiscoveryClient
@SpringBootApplication
public class BmsDemoTest3Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(BmsDemoTest3Application.class);

    public static void main(String[] args) {
        Instant start = Instant.now();
        SpringApplication.run(BmsDemoTest3Application.class, args);
        Instant end = Instant.now();
        Duration between = Duration.between(start, end);
        LOGGER.info("test3 started successfully. Take {} seconds.", between.getSeconds());
    }

}
