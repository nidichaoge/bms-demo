package com.mouse.bms.demo.zuul;

import com.mouse.bms.demo.zuul.filter.AccessFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.time.Instant;

@EnableZuulProxy
@SpringBootApplication
public class BmsDemoZuulApplication {

    //todo 动态路由 config
    //todo 动态过滤器 groovy
    private static final Logger LOGGER = LoggerFactory.getLogger(BmsDemoZuulApplication.class);
    public static void main(String[] args) {
        Instant start = Instant.now();
        SpringApplication.run(BmsDemoZuulApplication.class, args);
        Instant end = Instant.now();
        Duration between = Duration.between(start, end);
        LOGGER.info("zuul started successfully. Take {} seconds.", between.getSeconds());
    }

    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }

}
