package com.mouse.bms.demo.test6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.time.Duration;
import java.time.Instant;

@EnableDiscoveryClient
@SpringBootApplication
public class BmsDemoTest6Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(BmsDemoTest6Application.class);

    /**
     * 高可用
     * . 传统模式 所有的config server指向同一个仓库 在客户端指定server位置中间增加负载均衡即可
     * . 服务模式 config server作为微服务应用，纳入Eureka的服务治理体系中
     * <p>
     * 动态刷新
     * 引入actuator 需要调用一次/actuator/refresh才可动态获取git的配置 后续可使用消息总线Bus的方式
     */
    public static void main(String[] args) {
        Instant start = Instant.now();
        SpringApplication.run(BmsDemoTest6Application.class, args);
        Instant end = Instant.now();
        Duration between = Duration.between(start, end);
        LOGGER.info("config client started successfully. Take {} seconds.", between.getSeconds());
    }

}
