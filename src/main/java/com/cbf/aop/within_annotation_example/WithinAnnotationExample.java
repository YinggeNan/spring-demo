package com.cbf.aop.within_annotation_example;

import org.springframework.stereotype.Service;

/**
 * @Author yingge
 * @Date 2022/9/6 23:02
 */
@Service
@WithinAnnotation
public class WithinAnnotationExample {

    public void test1(){
        System.out.println("within test 1");
    }

    public void test2(){
        System.out.println("within test 2");
    }
}
