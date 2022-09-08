package com.cbf.aop.within_example;

import org.springframework.stereotype.Service;

/**
 * @Author yingge
 * @Date 2022/9/6 23:02
 */
@Service
public class WithinExampleImpl implements WithinExampleInterface {
    @Override
    public void test1(){
        System.out.println("within test 1");
    }
    @Override
    public void test2(){
        System.out.println("within test 2");
    }
}
