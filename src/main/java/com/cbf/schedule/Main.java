package com.cbf.schedule;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.config.Task;

/**
 * @Author yingge
 * @Date 2022/9/7 22:12
 */
public class Main {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
    }
}
