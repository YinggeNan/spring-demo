package com.cbf.aop.arg_example;

/**
 * @Author yingge
 * @Date 2022/9/6 22:13
 */
public class ArgExampleConcrete1 implements ArgFlyInterface {
    @Override
    public void fly() {
        System.out.println("concrete1 fly");
    }
}
