package com.cbf.el_spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author yingge
 * @Date 2022/9/7 8:26
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ELConfig.class);
        ELConfig elConfig = context.getBean(ELConfig.class);
        elConfig.outputResource();
        context.close();
    }
}
