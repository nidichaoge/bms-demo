package com.mouse.bms.demo.test8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.Instant;

@EnableDiscoveryClient
@SpringBootApplication
public class BmsDemoTest8Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(BmsDemoTest8Application.class);

    /**
     * 只需引入依赖sleuth，打印的日志就会增加如下信息:
     * [bms-demo-test,a18312016201c52e,3499190e73304ad1,false]
     * [当前应用名称,  TraceID(1链路1个), SpanID(1链路多个),是否要将该信息输出到Zipkin等服务中]
     *
     * 当与logstash整合时 由于logback-spring.xml中需要获取应用名，
     * 而其加载优先于application.properties,晚于bootstrap.properties，故需要把配置内容放在bootstrap.properties里面
     * @param args
     */
    public static void main(String[] args) {
        Instant start = Instant.now();
        SpringApplication.run(BmsDemoTest8Application.class, args);
        Instant end = Instant.now();
        Duration between = Duration.between(start, end);
        LOGGER.info("test8 started successfully. Take {} seconds.", between.getSeconds());
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
