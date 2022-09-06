package com.cbf.aop.excecution;

import java.lang.annotation.*;

/**
 * @Author yingge
 * @Date 2022/9/6 17:17
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {
    String name();
}
