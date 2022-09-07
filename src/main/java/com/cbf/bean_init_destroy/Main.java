package com.cbf.bean_init_destroy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author yingge
 * @Date 2022/9/7 12:02
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrePostConfig.class);
        context.getBean(BeanWayService.class);
        context.getBean(JSR250WayService.class);
        context.close();
    }
}
