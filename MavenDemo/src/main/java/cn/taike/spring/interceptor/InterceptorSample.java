package cn.taike.spring.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by huayandong on 17/8/28.
 */

/**
 * 继承HandlerInterceptorAdapter类，实现自定义拦截器
 */
public class InterceptorSample extends HandlerInterceptorAdapter {

    /**
     * 重写preHandle方法，在请求发生前执行
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }

    /**
     * 重写postHandle方法，在请求完成后执行
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        Long startTime = (Long) request.getAttribute("startTime");

        long endTime = System.currentTimeMillis();
        System.out.println("请求处理时间为：" + (endTime - startTime));
        request.setAttribute("handlingTime", (endTime - startTime));
    }
}
