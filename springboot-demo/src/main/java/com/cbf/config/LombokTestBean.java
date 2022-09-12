package com.cbf.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yingge
 * @Date 2022/9/12 22:42
 */
@Data
@Configuration
public class LombokTestBean {
    private String name = "cbf";
    private Integer age = 27;
}
