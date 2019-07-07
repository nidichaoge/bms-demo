package com.mouse.bms.demo.test3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@EnableDiscoveryClient
@SpringBootApplication
public class BmsDemoTest3Application {

    public static void main(String[] args) {
        SpringApplication.run(BmsDemoTest3Application.class, args);
    }

}
