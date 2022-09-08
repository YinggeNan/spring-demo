package com.cbf.combination_annotation;

/**
 * 使用 @WiselyConfiguration 代替 @Configuration、@ComponentScan
 * 设置value或 basePackages 参数都可以扫描包
 * @Author yingge
 * @Date 2022/9/8 11:59
 */
@WiselyConfiguration(value = "com.cbf.combination_annotation")
public class DemoConfig {
}
