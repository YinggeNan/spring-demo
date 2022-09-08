package com.cbf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @EnableWebMvc开启默认配置: ViewResolver或MessageConverter等
 * @Author yingge
 * @Date 2022/9/8 19:19
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.cbf")
public class MyMvcConfig {
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
}
