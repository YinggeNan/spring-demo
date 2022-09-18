package com.cbf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author yingge
 * @Date 2022/9/18 14:18
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        // 配置快捷页面转向,访问url host:port/indexgo时,转向 index页面
        registry.addViewController("/ajax-demo").setViewName("ajax-demo");
    }
}
