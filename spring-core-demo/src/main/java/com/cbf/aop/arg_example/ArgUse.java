package com.cbf.aop.arg_example;

import org.springframework.stereotype.Service;

/**
 * @Author yingge
 * @Date 2022/9/6 22:15
 */
@Service
public class ArgUse {
    public void useArgFly(ArgFlyInterface argFly){
        argFly.fly();
    }
}
