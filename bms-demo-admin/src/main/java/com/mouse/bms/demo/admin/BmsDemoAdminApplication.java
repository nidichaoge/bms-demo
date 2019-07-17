package com.mouse.bms.demo.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.time.Duration;
import java.time.Instant;

@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication
public class BmsDemoAdminApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(BmsDemoAdminApplication.class);

    public static void main(String[] args) {
        Instant start = Instant.now();
        SpringApplication.run(BmsDemoAdminApplication.class, args);
        Instant end = Instant.now();
        Duration between = Duration.between(start, end);
        LOGGER.info("admin server started successfully. Take {} seconds.", between.getSeconds());
    }

}
