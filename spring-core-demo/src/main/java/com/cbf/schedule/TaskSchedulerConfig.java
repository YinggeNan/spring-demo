package com.cbf.schedule;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author yingge
 * @Date 2022/9/7 22:11
 */
@Configuration
@ComponentScan("com.cbf.schedule")
@EnableScheduling
public class TaskSchedulerConfig {
}
