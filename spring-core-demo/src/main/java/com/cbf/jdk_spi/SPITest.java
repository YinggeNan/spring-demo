package com.cbf.jdk_spi;

import com.cbf.interface_all_implement.SpringGetAllTestInterface;

import java.util.ServiceLoader;

/**
 * @Author yingge
 * @Date 2022/9/16 22:07
 */
public class SPITest {
    public static void main(String[] args) {
        ServiceLoader<SpringGetAllTestInterface> loader = ServiceLoader.load(SpringGetAllTestInterface.class);
        for(SpringGetAllTestInterface impl: loader){
            System.out.println(impl.getClass().getName());
        }
    }
}
