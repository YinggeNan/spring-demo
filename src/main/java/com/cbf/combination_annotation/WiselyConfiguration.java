package com.cbf.combination_annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * @Author yingge
 * @Date 2022/9/8 11:56
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration // 组合@Configuration
@ComponentScan // 组合@ComponentScan
public @interface WiselyConfiguration {
    String[] value() default {}; // 覆盖value参数
    String[] basePackages() default {}; // 覆盖basePackages参数
}
