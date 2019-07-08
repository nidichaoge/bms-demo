package com.mouse.bms.demo.test2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.Instant;

@EnableHystrixDashboard // hystrix dashboard
@EnableCircuitBreaker //hystrix
@EnableDiscoveryClient //ribbon
@SpringBootApplication
//@SpringCloudApplication 可替代上面三个
public class BmsDemoTest2Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(BmsDemoTest2Application.class);

    public static void main(String[] args) {
        Instant start = Instant.now();
        SpringApplication.run(BmsDemoTest2Application.class, args);
        Instant end = Instant.now();
        Duration between = Duration.between(start, end);
        LOGGER.info("test2 started successfully. Take {} seconds.", between.getSeconds());
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
