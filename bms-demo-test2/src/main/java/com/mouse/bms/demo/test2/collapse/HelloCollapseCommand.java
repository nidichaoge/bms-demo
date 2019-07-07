package com.mouse.bms.demo.test2.collapse;

import com.netflix.hystrix.HystrixCollapser;
import com.netflix.hystrix.HystrixCommand;

import java.util.Collection;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-07 20:09
 * @description 请求合并 对应的注解 @HystrixCollapser
 */
public class HelloCollapseCommand extends HystrixCollapser {
    @Override
    public Object getRequestArgument() {
        return null;
    }

    @Override
    protected void mapResponseToRequests(Object o, Collection collection) {

    }

    @Override
    protected HystrixCommand createCommand(Collection collection) {
        return null;
    }

}
