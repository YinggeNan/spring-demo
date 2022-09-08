package com.cbf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author yingge
 * @Date 2022/9/8 21:05
 */
@Controller
public class HelloController {
    @RequestMapping("/index") // 2.配置URL和方法之间的映射
    public String hello(){
        return "index"; // 3.通过之前 viewResolver的bean配置,返回值是index,说明我们的页面放置的路径为 /WEB-INF/classes/views/index.jsp
    }
}
