package com.cbf.controller;

import com.cbf.bean.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * spring mvc 常用注解演示
 * @Author yingge
 * @Date 2022/9/8 22:59
 */
@Controller // 1.表明是一个控制器
@RequestMapping("/anno") // 2.此类的映射路径为/anno
public class DemoAnnoController {
    /**
     * 3.该方法的@RequestMapping没有指定路径,所以继承使用父类路径/anno
     * produces可以定制返回response的媒体类型和字符集,如果需要返回值是json对象,就设置 produces="application/json;charset=UTF-8"
     * @param request
     * @return
     */
    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public @ResponseBody String index(HttpServletRequest request){ // 4.演示可以接受HttpServletRequest作为参数,当然也可以接受HttpServletResponse作为参数
        return "url:" + request.getRequestURL() + " can access";
    }

    /**
     * 5.演示接受路径参数,并在方法参数前结合@PathVariable,访问路径为 /anno/pathvar/xx
     * @param str
     * @param request
     * @return
     */
    @RequestMapping(value = "/pathvar/{str}",produces = "text/plain;charset=UTF-8")
    public @ResponseBody String demoPathVar(@PathVariable String str, HttpServletRequest request){
        return "url:" + request.getRequestURL() + " can access,str:" + str;
    }

    /**
     * 6.演示常规的request参数获取,访问路径为 /anno/requestParam?id=1
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "requestParam", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String passRequestParam(Long id, HttpServletRequest request){
        return "url:" + request.getRequestURL() + " can access,id: " + id;
    }

    /**
     * 7.演示解释参数到对象,访问路径为 /anno/obj?id=1&name=xx
     * @param obj
     * @param request
     * @return
     */
    @RequestMapping(value = "obj", produces = "text/plain;charset=UTF-8")
    @ResponseBody // 演示 @ResponseBody也可以用在方法上
    public String passObj(DemoObj obj, HttpServletRequest request){
        return "url:" + request.getRequestURL() + " can access, obj id: " + obj.getId() + " obj name: " + obj.getName();
    }

    /**
     * 9.演示 映射不同路径到相同的方法上, 访问路径为 /anno/name1 或 /anno/name2
     * @param request
     * @return
     */
    @RequestMapping(value = {"/name1", "/name2"}, produces = "text/plain;charset=UTF-8")
    public @ResponseBody String remove(HttpServletRequest request){
        return "url:" + request.getRequestURL() + " can access";
    }
}
