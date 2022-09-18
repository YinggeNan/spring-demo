package com.cbf.bean;

import lombok.Data;

/**
 * @Author yingge
 * @Date 2022/9/15 23:14
 */
@Data
public class Person {
    private String name;
    private Integer age;
    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
    }
}
