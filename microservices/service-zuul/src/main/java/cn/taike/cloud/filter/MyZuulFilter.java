package cn.taike.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by huayandong on 17/7/24.
 */
@Component
public class MyZuulFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(MyZuulFilter.class);

    /*
        过滤器的类型：
            pre:路由之前
            routing:在路由之时
            post:路由之后
            error:发送错误调用
     */
    @Override
    public String filterType() {
        return "pre"; //在路由之前执行
    }

    //表示过滤的顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    //表是否需要过滤，true表示永远执行
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //run:过滤器的具体逻辑
    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        logger.info("[{}] ---> [{}]", request.getMethod(), request.getRequestURL().toString());

        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)) {
            logger.warn("token is empty!!!");
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            try {
                currentContext.getResponse().getWriter().write("token is empty!");
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
        logger.info("OK! PASS~");
        return null;
    }
}
