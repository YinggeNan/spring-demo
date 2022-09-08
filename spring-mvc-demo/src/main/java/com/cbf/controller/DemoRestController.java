package com.cbf.controller;

import com.cbf.bean.DemoObj;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yingge
 * @Date 2022/9/8 23:26
 */
@RestController // 1.@RestController,声明是控制器,返回数据时不需要@ResponsBody
@RequestMapping("/rest")
public class DemoRestController {
    /**
     * 2.返回数据类型为json
     * 样例访问url: localhost:8080/rest/getjson?id=1&name=cbf
     * @param obj
     * @return
     */
    @RequestMapping(value =  "/getjson",produces = ("application/json;charset=UTF-8"))
    public DemoObj getJson(DemoObj obj){
        return new DemoObj(obj.getId() + 1, obj.getName() + "yy"); // 3.直接返回对象,对象会直接转化为json
    }
    // 4.返回数据的媒体类型为xml

    /**
     *
     * 样例访问url: localhost:8080/rest/getxml?id=1&name=cbf
     * @param obj
     * @return
     */
    @RequestMapping(value="/getxml", produces = {"application/xml;charset=UTF-8"})
    public DemoObj  getXml(DemoObj obj){
        return new DemoObj(obj.getId()+1, obj.getName()+"yy"); // 5.直接返回对象,对象会直接转化为xml
    }
}
