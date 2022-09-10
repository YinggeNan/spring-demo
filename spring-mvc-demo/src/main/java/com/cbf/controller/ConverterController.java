package com.cbf.controller;

import com.cbf.bean.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author yingge
 * @Date 2022/9/10 11:05
 */
@Controller
public class ConverterController {

    // 指定返回的媒体类型为我们自定义的媒体类型 application/x-wisely
    // 这里一定要用@RequestBody注解参数
    @RequestMapping(value = "/convert", produces = {"application/x-wisely"})
    public @ResponseBody DemoObj convert(@RequestBody DemoObj obj){
        return obj;
    }
}
