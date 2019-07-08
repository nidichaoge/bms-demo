package com.mouse.bms.demo.test4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

import java.time.Duration;
import java.time.Instant;

@EnableTurbineStream
@EnableDiscoveryClient
@SpringBootApplication
public class BmsDemoTest4Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(BmsDemoTest4Application.class);

    //todo turbine stream
    public static void main(String[] args) {
        Instant start = Instant.now();
        SpringApplication.run(BmsDemoTest4Application.class, args);
        Instant end = Instant.now();
        Duration between = Duration.between(start, end);
        LOGGER.info("test4 started successfully. Take {} seconds.", between.getSeconds());
    }

}
