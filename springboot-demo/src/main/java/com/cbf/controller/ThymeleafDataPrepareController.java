package com.cbf.controller;

import com.cbf.bean.Person;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * @Author yingge
 * @Date 2022/9/15 23:14
 */
@Controller
public class ThymeleafDataPrepareController {

    @RequestMapping("/themeleaf")
    public String index(Model model){
        Person single = new Person("aa", 11);
        ArrayList<Person> people = new ArrayList<>();
        Person p1 = new Person("xx", 11);
        Person p2 = new Person("yy", 22);
        Person p3 = new Person("zz", 33);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);
        return "index";
    }
    @RequestMapping(value = "/greeting")
    public ModelAndView test(ModelAndView mv) {
        mv.setViewName("/greeting");
        mv.addObject("title","欢迎使用Thymeleaf!");
        return mv;
    }

    @RequestMapping("/api/categories")
    @ResponseBody
    public String ajax(ModelAndView mv){
        return "categories";
    }
}
