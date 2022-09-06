package com.cbf.aop.arg_annotation_example;

import org.springframework.stereotype.Service;

/**
 * @Author yingge
 * @Date 2022/9/6 22:15
 */
@Service
public class ArgAnnotationUse {
    public void useArgAnnotation(ArgExampleAnnotatedByArgFlyAnnotation arg){
        System.out.println("use argAnnotation");
    }
}
