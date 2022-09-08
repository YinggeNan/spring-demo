package com.cbf.combination_annotation;

import org.springframework.stereotype.Service;

/**
 * @Author yingge
 * @Date 2022/9/8 11:58
 */
@Service
public class DemoService {
    public void outputResult(){
        System.out.println("从组合注解配置照样获得的bean");
    }
}
