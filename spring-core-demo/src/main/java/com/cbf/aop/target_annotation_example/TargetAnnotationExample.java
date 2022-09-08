package com.cbf.aop.target_annotation_example;

import org.springframework.stereotype.Service;

@TargetAnnotation
@Service
public class TargetAnnotationExample {

    public void test1(){
        System.out.println("target test 1");
    }

    public void test2(){
        System.out.println("target test 2");
    }
}
