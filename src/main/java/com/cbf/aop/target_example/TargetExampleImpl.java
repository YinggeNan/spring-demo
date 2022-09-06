package com.cbf.aop.target_example;

import org.springframework.stereotype.Service;

/**
 * @Author yingge
 * @Date 2022/9/6 23:02
 */
@Service
public class TargetExampleImpl implements TargetExampleInterface{
    @Override
    public void test1(){
        System.out.println("target test 1");
    }
    @Override
    public void test2(){
        System.out.println("target test 2");
    }
}
