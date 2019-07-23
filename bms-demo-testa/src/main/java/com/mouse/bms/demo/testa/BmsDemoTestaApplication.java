package com.mouse.bms.demo.testa;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.time.Duration;
import java.time.Instant;

@EnableWebSecurity
@SpringBootApplication
@MapperScan("com.mouse.bms.demo.testa.dao")
public class BmsDemoTestaApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(BmsDemoTestaApplication.class);

    /**
     * 使用基于内存的方式配置,角色前不能以ROLE_开头,否则报错,(框架会自动添加),但是当同时赋予一个用户角色和权限时，@PreAuthorize注解的hasRole会不起作用
     * 使用认证的方式,角色前必须添加ROLE_,否则报错;
     *
     * 基于url动态权限的三种方案(需要role_permission 和permission表),其中23需要相同的AccessDecisionManager和FilterInvocationSecurityMetadataSource
     *  . 扩展access()表达式
     *  . 自定义AccessDecisionManager 需要ObjectPostProcessor
     *  . 自定义Filter 需要AbstractSecurityInterceptor
     */
    public static void main(String[] args) {
        Instant start = Instant.now();
        SpringApplication.run(BmsDemoTestaApplication.class, args);
        Instant end = Instant.now();
        Duration between = Duration.between(start, end);
        LOGGER.info("testa started successfully. Take {} seconds.", between.getSeconds());
    }

}
