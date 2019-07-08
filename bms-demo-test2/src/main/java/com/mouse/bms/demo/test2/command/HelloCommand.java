package com.mouse.bms.demo.test2.command;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-07 18:24
 * @description
 */
public class HelloCommand extends HystrixCommand<String> {

    private RestTemplate restTemplate;

    public HelloCommand(Setter setter, RestTemplate restTemplate) {
        super(setter);
        this.restTemplate = restTemplate;
    }

    @Override
    protected String run() throws Exception {
        return restTemplate.getForEntity("http://bms-demo-test/hello", String.class).getBody();

    }

    /**
     * 失败执行此方法
     *
     * @return
     */
    @Override
    protected String getFallback() {
        return "helloCommand";
    }

    /**
     * 开启缓存
     *
     * @return
     */
    @Override
    protected String getCacheKey() {
        return super.getCacheKey();
    }

}
