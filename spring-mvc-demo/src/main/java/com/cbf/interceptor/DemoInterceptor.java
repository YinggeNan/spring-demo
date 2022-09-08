package com.cbf.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author yingge
 * @Date 2022/9/9 0:06
 */
public class DemoInterceptor extends HandlerInterceptorAdapter { // 1.继承HandlerInterceptorAdapter实现自定义拦截器
    // 2. 重写 preHandle 方法,在 请求发生前 执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return super.preHandle(request, response, handler);
    }

    // 3. 重写 postHandle 方法,在 请求完成后 执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.out.println("this request handling :" + new Long(endTime - startTime) + "ms");
        request.setAttribute("the processing time of this request is :", endTime - startTime);
        super.postHandle(request, response, handler, modelAndView);
    }
}
