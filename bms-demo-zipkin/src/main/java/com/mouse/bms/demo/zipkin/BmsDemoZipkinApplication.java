package com.mouse.bms.demo.zipkin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

import java.time.Duration;
import java.time.Instant;

@EnableZipkinServer
@SpringBootApplication
public class BmsDemoZipkinApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(BmsDemoZipkinApplication.class);
    /**
     * 需要注意的是: 引入zipkin-server 和zipkin-autoconfigure-ui时,默认页面在127.0.0.1:8080,应用端口号不能使用8080
     *             但是zipkin的client默认使用的是9411,因此需手动配置127.0.0.1:8080
     * @param args
     */
    public static void main(String[] args) {
        Instant start = Instant.now();
        SpringApplication.run(BmsDemoZipkinApplication.class, args);
        Instant end = Instant.now();
        Duration between = Duration.between(start, end);
        LOGGER.info("zipkin started successfully. Take {} seconds.", between.getSeconds());
    }

}
