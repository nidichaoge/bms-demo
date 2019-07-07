package com.mouse.bms.demo.test2.command;

import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixObservableCommand;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-07 18:36
 * @description
 */
public class HelloObservableCommand extends HystrixObservableCommand<String> {

    private static final HystrixCommandKey KEY = HystrixCommandKey.Factory.asKey("hello");

    private RestTemplate restTemplate;

    public HelloObservableCommand(Setter setter, RestTemplate restTemplate) {
        super(setter);
        this.restTemplate = restTemplate;
    }

    @Override
    protected Observable<String> construct() {
        return Observable.create(subscriber -> {
            try {
                if (!subscriber.isUnsubscribed()) {
                    String body = restTemplate.getForEntity("http://bms-demo-test/hello", String.class).getBody();
                    subscriber.onNext(body);
                    subscriber.onCompleted();
                }
            } catch (Exception e) {
                subscriber.onError(e);
            }
        });
    }

    /**
     * 失败执行此方法
     *
     * @return
     */
    @Override
    protected Observable<String> resumeWithFallback() {
        return super.resumeWithFallback();
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

    /**
     * 清除缓存
     * 缓存什么 对应就清除什么
     */
    public void flushKey() {
        HystrixRequestCache.getInstance(KEY, HystrixConcurrencyStrategyDefault.getInstance()).clear("");
    }
}
