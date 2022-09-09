package com.cbf.config;

import com.cbf.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @EnableWebMvc开启默认配置: ViewResolver或MessageConverter等
 * @Author yingge
 * @Date 2022/9/8 19:19
 */
@Configuration
@EnableWebMvc // 1.开启Springmvc支持,如果没有这句,重写 WebMvcConfigurerAdapter方法无效
@ComponentScan("com.cbf")
public class MyMvcConfig extends WebMvcConfigurerAdapter { // 2.继承WebMvcConfigurerAdapter,重写方法则可对springmvc进行配置
    /**
     * 配置一个JSP ViewResolver,映射路径和实际页面的位置
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        // 这里是运行时目录结构,不是开发时的目录结构
        // springboot中使用Thymeleaf作为模板,所以不需要这样的配置
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        // 3.addResourceLocations指的是文件放置的目录, addResourceHandler指的是对外暴露的访问路径
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }
    // 配置自定义拦截器
    @Bean
    public DemoInterceptor demoInterceptor(){
        return new DemoInterceptor();
    }

    // 重写 addInterceptors, 注册拦截器
    // url访问样例: localhost:8080/index
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
        super.addInterceptors(registry);
    }

    @Override // 配置快捷页面转向,访问url host:port/indexgo时,转向 index页面
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/indexgo").setViewName("/index");
    }
}
