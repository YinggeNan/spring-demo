package com.cbf.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author yingge
 * @Date 2022/9/12 11:06
 */
@Configuration
@ConfigurationProperties(prefix = "scb")
@PropertySource(value = {"classpath:type-security-config.properties"})
public class TypeSecurityConfigProperties {
    private String name;
    private Integer age;
    private String backGround;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBackGround(String backGround) {
        this.backGround = backGround;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getBackGround() {
        return backGround;
    }
}
