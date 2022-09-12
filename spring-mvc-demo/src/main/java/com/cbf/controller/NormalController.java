package com.cbf.controller;

import com.cbf.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author yingge
 * @Date 2022/9/11 9:57
 */
@Controller
public class NormalController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/normal")
    public String testPage(Model model){
        model.addAttribute("msg", demoService.saySomething());
        return "page";
    }
}
