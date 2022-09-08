package com.cbf.aop.excecution;

import org.springframework.stereotype.Service;

/**
 * @Author yingge
 * @Date 2022/9/6 17:16
 */
@Service
public class DemoAnnotationService {
    @Action(name="注解式拦截的add操作")
    public void add(){
    }
}
