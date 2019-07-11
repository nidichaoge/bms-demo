package com.mouse.bms.demo.test7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.time.Instant;

@SpringBootApplication
public class BmsDemoTest7Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(BmsDemoTest7Application.class);
    public static void main(String[] args) {
        Instant start = Instant.now();
        SpringApplication.run(BmsDemoTest7Application.class, args);
        Instant end = Instant.now();
        Duration between = Duration.between(start, end);
        LOGGER.info("bus started successfully. Take {} seconds.", between.getSeconds());
    }

}
