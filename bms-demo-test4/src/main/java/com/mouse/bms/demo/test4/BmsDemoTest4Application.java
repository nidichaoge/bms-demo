package com.mouse.bms.demo.test4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

@EnableTurbineStream
@EnableDiscoveryClient
@SpringBootApplication
public class BmsDemoTest4Application {

    public static void main(String[] args) {
        SpringApplication.run(BmsDemoTest4Application.class, args);
    }

}
