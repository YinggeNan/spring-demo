package com.cbf.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 1. WebApplicationInitializer是Spring用来配置Servlet3.0+配置的接口,用于替代web.xml
 * 实现此接口将会自动被SpringServletContainerInitializer(用于启动Servlet3.0)获取到
 * @Author yingge
 * @Date 2022/9/8 19:25
 */
public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(MyMvcConfig.class);
        context.setServletContext(servletContext); // 2.新建WebApplicationContext,注册配置类,并将其和当前servletContext关联
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context)); // 3.注册spring mvc的 DispatcherServlet
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
