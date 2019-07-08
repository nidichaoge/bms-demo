package com.mouse.bms.demo.test2.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.Future;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-07 16:49
 * @description
 */
@Service
public class ConsumeService {

    @Resource
    private RestTemplate restTemplate;

    /**
     * 同步实现
     * fallbackMethod 失败后执行的方法
     * ignoreExceptions 忽略此异常 只有这个HystrixBadRequestException不会进入熔断方法,忽略的异常实际包装成了这个异常
     * commandKey
     * groupKey
     * threadPoolKey
     *
     * @return
     */
    @HystrixCommand(fallbackMethod = "defaultConsume",
            ignoreExceptions = {RuntimeException.class},
            commandKey = "command",
            groupKey = "group",
            threadPoolKey = "threadPool")
    /**
     * 开启缓存
     */
//    @CacheResult(cacheKeyMethod = "defaultCache")
//    @CacheKey 需要注解对参数上
    /**
     * 清除缓存 一般用在写的操作
     */
//    @CacheRemove(commandKey = "")
    public String consume() {
        return restTemplate.getForEntity("http://bms-demo-test/hello", String.class).getBody();
    }

    /**
     * 异步实现
     *
     * @return
     */
    @HystrixCommand
    public Future<String> consume2() {
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                return restTemplate.getForEntity("http://bms-demo-test/hello", String.class).getBody();
            }
        };
    }

    /**
     * 调用失败进入此方法，此方法也可能失败
     *
     * @return
     */
    @HystrixCommand(fallbackMethod = "defaultConsume2")
    private String defaultConsume() {
        return "first error";
    }

    private String defaultConsume2() {
        return "second error";
    }

    /**
     * 缓存key的方法
     *
     * @return
     */
    private String defaultCache() {
        return "hello";
    }

}
