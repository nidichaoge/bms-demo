package com.mouse.bms.demo.testa.permission;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-21 21:57
 * @description
 * FilterInvocationSecurityMetadataSource 的作用是用来储存请求与权限的对
 */
//@Component
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyInvocationSecurityMetadataSourceService.class);

    @Resource
    private PermissionService permissionService;

    /**
     * 返回请求的资源需要的角色
     * 当接收到一个http请求时, filterSecurityInterceptor会调用的方法.
     * 参数object是一个包含url信息的HttpServletRequest实例. 这个方法要返回请求该url所需要的所有权限集合。
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        Map<String, Collection<ConfigAttribute>> permission = permissionService.getPermission();

        //object 中包含用户请求的request 信息
        FilterInvocation filterInvocation = (FilterInvocation) object;
        LOGGER.info("requestUrl:{}.",filterInvocation.getFullRequestUrl());
        if (isMatcherAllowedRequest(filterInvocation)){
            return null; //表示允许访问不做拦截
        }
        HttpServletRequest request = filterInvocation.getHttpRequest();
        for (Iterator<String> it = permission.keySet().iterator(); it.hasNext();) {
            String url = it.next();
            if (new AntPathRequestMatcher( url ).matches( request )) {
                return permission.get( url );
            }
        }
        return null;
    }

    /**
     *Spring容器启动时自动调用, 一般把所有请求与权限的对应关系也要在这个方法里初始化, 保存在一个属性变量里
     */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    /**
     * 指示该类是否能够为指定的方法调用或Web请求提供ConfigAttributes。
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    /**
     * 判断当前请求是否在允许请求的范围内
     * @param fi 当前请求
     * @return 是否在范围中
     */
    private boolean isMatcherAllowedRequest(FilterInvocation fi){
        return allowedRequest().stream().map(AntPathRequestMatcher::new)
                .filter(requestMatcher -> requestMatcher.matches(fi.getHttpRequest()))
                .toArray().length > 0;
    }

    /**
     * @return 定义允许请求的列表
     */
    private List<String> allowedRequest(){
        return Arrays.asList("/login","/css/**","/fonts/**","/js/**","/scss/**","/img/**");
    }

}