package com.cbf.controller;

import com.cbf.bean.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author yingge
 * @Date 2022/9/9 23:11
 */
@Controller
public class AdviceController {
    // @ModelAttribute("msg") 可以获得 全局配置中 用@ModelAttribute注解的方法中给model设置的key的value
    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, DemoObj obj){
        throw new IllegalArgumentException("sorry, parameter has error/n"+"come from @ModelAttribute:"+msg);
    }
}
