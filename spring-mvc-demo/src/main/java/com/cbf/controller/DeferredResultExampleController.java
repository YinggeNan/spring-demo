package com.cbf.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ForkJoinPool;

/**
 * @Author yingge
 * @Date 2022/9/10 15:37
 */
@RestController
@RequestMapping("/deferred")
public class DeferredResultExampleController {

    @RequestMapping("/completionCallback")
    public DeferredResult<ResponseEntity<String>> deferredCompletionCallbackExample() {
        DeferredResult<ResponseEntity<String>> deferredResult = new DeferredResult<>();
        deferredResult.onCompletion(() -> System.out.println("Processing complete"));
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                deferredResult.setResult(ResponseEntity.ok("OK"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        return deferredResult;
    }
//    @RequestMapping("/errorCallback")
//    public DeferredResult<ResponseEntity<String>> deferredErrorCallbackExample() {
//        DeferredResult<ResponseEntity<String>> deferredResult = new DeferredResult<>();
//        deferredResult.onError((Throwable t) -> {
//            deferredResult.setErrorResult(
//                    ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                            .body("An error occurred."));
//        });
//        return null;
//    }
    @RequestMapping("/timeoutCallback")
    public DeferredResult<ResponseEntity<String>> deferredTimeoutCallbackExample() {
        DeferredResult<ResponseEntity<String>> deferredResult = new DeferredResult<>(500l);
        deferredResult.onTimeout(() ->
                deferredResult.setErrorResult(
                        ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT)
                                .body("Request timeout occurred.")));

        ForkJoinPool.commonPool().submit(() -> {
            System.out.println("Processing in separate thread");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {

            }
            deferredResult.setResult(ResponseEntity.ok("OK"));
        });
        return deferredResult;
    }

    @RequestMapping("/noDeferred")
    public String noDeferredExample(){
        try {
            Thread.sleep(10000);
            return "ok";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
