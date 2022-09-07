package com.cbf.java_config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author yingge
 * @Date 2022/9/7 18:03
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello("java config"));
        context.close();
    }
}
