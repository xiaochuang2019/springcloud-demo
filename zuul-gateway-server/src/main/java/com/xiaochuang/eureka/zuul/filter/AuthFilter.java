package com.xiaochuang.eureka.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthFilter extends ZuulFilter {
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
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)){
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            HttpServletResponse response = currentContext.getResponse();
            response.setContentType("application/json;charset=utf-8");
            try {
                response.getWriter().write("{\"message\":\"未授权\"}");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
