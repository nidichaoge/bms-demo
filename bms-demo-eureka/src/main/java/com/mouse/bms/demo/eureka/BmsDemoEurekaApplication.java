package com.mouse.bms.demo.eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.time.Duration;
import java.time.Instant;

@EnableEurekaServer
@SpringBootApplication
public class BmsDemoEurekaApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(BmsDemoEurekaApplication.class);

    public static void main(String[] args) {
        Instant start = Instant.now();
        SpringApplication.run(BmsDemoEurekaApplication.class, args);
        Instant end = Instant.now();
        Duration between = Duration.between(start, end);
        LOGGER.info("eureka server started successfully. Take {} seconds.", between.getSeconds());
    }

}
