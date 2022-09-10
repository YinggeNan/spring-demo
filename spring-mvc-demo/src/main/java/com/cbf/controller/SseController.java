package com.cbf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * @Author yingge
 * @Date 2022/9/10 14:27
 */
@Controller
public class SseController {
    // 1.输出的媒体类型为 text/event-stream,这是服务端SSE的支持
    @RequestMapping(value = "/push", produces = "text/event-stream")
    public @ResponseBody String push(){
        Random random = new Random();
        try {
            // 每 5s 向浏览器 推送随机消息
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "data:Testing 1,2,3" + random.nextInt() + "\n\n";
    }
}
