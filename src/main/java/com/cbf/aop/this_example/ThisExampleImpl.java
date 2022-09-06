package com.cbf.aop.this_example;

import org.springframework.stereotype.Service;

/**
 * @Author yingge
 * @Date 2022/9/6 23:02
 */
@Service
public class ThisExampleImpl implements ThisExampleInterface {
    @Override
    public void test1(){
        System.out.println("this test 1");
    }
    @Override
    public void test2(){
        System.out.println("this test 2");
    }
}
