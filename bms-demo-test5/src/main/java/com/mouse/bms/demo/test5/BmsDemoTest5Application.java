package com.mouse.bms.demo.test5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.mouse.bms.demo.test5.service")
@EnableDiscoveryClient
//@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.mouse.bms.demo.test5"})
public class BmsDemoTest5Application {

    public static void main(String[] args) {
        SpringApplication.run(BmsDemoTest5Application.class, args);
    }

}
