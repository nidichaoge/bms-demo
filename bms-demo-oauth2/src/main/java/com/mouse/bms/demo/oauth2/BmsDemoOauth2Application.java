package com.mouse.bms.demo.oauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.time.Duration;
import java.time.Instant;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.mouse.bms.demo.oauth2.dao")
public class BmsDemoOauth2Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(BmsDemoOauth2Application.class);

    public static void main(String[] args) {
        Instant start = Instant.now();
        SpringApplication.run(BmsDemoOauth2Application.class, args);
        Instant end = Instant.now();
        Duration between = Duration.between(start, end);
        LOGGER.info("oauth2 server started successfully. Take {} seconds.", between.getSeconds());
    }

}
