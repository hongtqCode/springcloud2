package com.hongtq.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 自定义过滤器
 */
@Component
public class Filter_002 extends ZuulFilter {

    /**
     * 过滤器类型,分为前置拦截pre 后置拦截post
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的优先级 由0开始
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 判断请求是否进行拦截的逻辑,ture为拦截,false为不拦截
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String param = request.getParameter("test2");
        if ("first".equals(param)){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 执行拦截的业务逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String param = request.getParameter("test");
        if (param == null || "".equals(param.trim())){
            try {
                //设置不在向下调用,采用response给客户端反馈信息
                context.setSendZuulResponse(false);
                context.getResponse().getWriter().print("系统繁忙");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
