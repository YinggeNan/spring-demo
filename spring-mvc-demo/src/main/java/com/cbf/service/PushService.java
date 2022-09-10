package com.cbf.service;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @Author yingge
 * @Date 2022/9/10 14:56
 */
@Service
public class PushService {
    // 1.在PushService里产生 DeferredResult给控制器使用
    private DeferredResult<String> deferredResult;

    public DeferredResult<String> getAsyncUpdate(){
        deferredResult = new DeferredResult<>();
        return deferredResult;
    }
    // 2.通过 @Scheduled注解的方法定时更新 deferredResult
    @Scheduled( fixedDelay =  5000)
    public void refresh(){
        if(deferredResult != null){
            // 异步任务完成时,就调用 setResult方法
            deferredResult.setResult(Long.toString(System.currentTimeMillis()));
        }
    }
}
