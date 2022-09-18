package com.cbf.interface_all_implement;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @Author yingge
 * @Date 2022/9/16 21:52
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        JavaConfig config = context.getBean(JavaConfig.class);
        Map<String, SpringGetAllTestInterface> beansOfType = config.getBeansOfType();
        Map<String, SpringGetAllTestInterface> beansOfType1 = config.getBeansOfType1();
         System.out.println();
    }
}
