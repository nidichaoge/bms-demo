package com.mouse.bms.demo.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.tools.jconsole.Plotter;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-08 22:41
 * @description
 */
public class AccessFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        LOGGER.info("method:{}, url:{}.", request.getMethod(), request.getRequestURL());
        String accessToken = request.getParameter("accessToken");
        if (Objects.isNull(accessToken)) {
            LOGGER.warn("accesstoken is empty");
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            return null;
        }
        LOGGER.info("accesstoken is ok");
        return null;
    }

}
