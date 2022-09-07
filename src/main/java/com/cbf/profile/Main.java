package com.cbf.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;

/**
 * @Author yingge
 * @Date 2022/9/7 16:21
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("prod"); //先将活动Profile设置为prod
        context.register(ProfileConfig.class); // 后置注册bean配置类,否则会报bean未定义错误
        context.refresh(); // 刷新container
        DemoBean demoBean = context.getBean(DemoBean.class);
        System.out.println(demoBean.getContent());
        context.close();
    }
}
