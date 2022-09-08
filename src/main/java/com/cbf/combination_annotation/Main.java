package com.cbf.combination_annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author yingge
 * @Date 2022/9/8 11:59
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        DemoService demoService = context.getBean(DemoService.class);
        demoService.outputResult();
        context.close();
    }
}
