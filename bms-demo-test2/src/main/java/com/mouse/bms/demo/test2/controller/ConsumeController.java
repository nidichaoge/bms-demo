package com.mouse.bms.demo.test2.controller;

import com.mouse.bms.demo.test2.command.HelloCommand;
import com.mouse.bms.demo.test2.command.HelloObservableCommand;
import com.mouse.bms.demo.test2.service.ConsumeService;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixObservableCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-07 16:06
 * @description
 */
@RestController
public class ConsumeController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private ConsumeService consumeService;

    /**
     * 直接调用
     *
     * @return
     */
    @GetMapping("/consume")
    public String consume() {
        return restTemplate.getForEntity("http://bms-demo-test/hello", String.class).getBody();
    }

    /**
     * ConsumeService调用 hystrix 同步
     *
     * @return
     */
    @GetMapping("/consume2")
    public String consume2() {
        return consumeService.consume();
    }

    /***
     * ConsumeService调用 hystrix 异步
     * @return
     */
    @GetMapping("/consume3")
    public String consume3() throws ExecutionException, InterruptedException {
        Future<String> stringFuture = consumeService.consume2();
        return stringFuture.get();
    }

    /**
     * HystrixCommand 同步
     *
     * @return
     */
    @GetMapping("/consume4")
    public String consume4() {
        HelloCommand helloCommand = new HelloCommand(
                HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("consume4 group"))
                        .andCommandKey(HystrixCommandKey.Factory.asKey("consume4 command")), restTemplate);
        String result = helloCommand.execute();
        return result;
    }

    /**
     * HystrixCommand 异步
     *
     * @return
     */
    @GetMapping("/consume5")
    public String consume5() throws ExecutionException, InterruptedException {
        HelloCommand helloCommand = new HelloCommand(
                HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("consume5 group"))
                        .andCommandKey(HystrixCommandKey.Factory.asKey("consume5 command")), restTemplate);
        Future<String> queue = helloCommand.queue();

        return queue.get();
    }

    /**
     * HystrixObservableCommand 返回Hot Observable 立即执行
     *
     * @return
     */
    @GetMapping("/consume6")
    public String consume6() {
        HelloObservableCommand observableCommand = new HelloObservableCommand(
                HystrixObservableCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("consume6 group"))
                        .andCommandKey(HystrixCommandKey.Factory.asKey("consume6 command")), restTemplate);
        Observable<String> observe = observableCommand.observe();
        System.out.println(observe);
        return "hot Observable";
    }

    /**
     * HystrixObservableCommand 返回Cold Observable 不会立即执行
     *
     * @return
     */
    @GetMapping("/consume7")
    public String consume7() {
        HelloObservableCommand observableCommand = new HelloObservableCommand(
                HystrixObservableCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("consume7"))
                        .andCommandKey(HystrixCommandKey.Factory.asKey("consume7 command")), restTemplate);
        Observable<String> observable = observableCommand.toObservable();
        System.out.println(observable);
        return "cold Observable";
    }

}
