package com.mouse.bms.demo.test5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.time.Instant;

@EnableFeignClients
@EnableDiscoveryClient
//@EnableEurekaClient
@SpringBootApplication
public class BmsDemoTest5Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(BmsDemoTest5Application.class);

    public static void main(String[] args) {
        Instant start = Instant.now();
        SpringApplication.run(BmsDemoTest5Application.class, args);
        Instant end = Instant.now();
        Duration between = Duration.between(start, end);
        LOGGER.info("test5 started successfully. Take {} seconds.", between.getSeconds());
    }

    @Bean
    public feign.Logger.Level feignLoggerLevel(){
        return feign.Logger.Level.FULL;
    }

}
