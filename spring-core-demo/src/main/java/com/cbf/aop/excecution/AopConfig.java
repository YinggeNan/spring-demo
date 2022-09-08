package com.cbf.aop.excecution;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author yingge
 * @Date 2022/9/6 17:51
 */
@Configuration
@ComponentScan("com.cbf.aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopConfig {
}
