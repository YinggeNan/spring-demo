package com.cbf.config;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author yingge
 * @Date 2022/9/9 23:03
 */
@ControllerAdvice // 1.声明一个建言控制器,组合了@Component注解,所以自动注册为spring的bean
public class ExceptionGlobalHandlerAdvice {

    @ExceptionHandler(value = Exception.class) // 2.定义全局异常处理, value属性设置过滤拦截条件,此处说明拦截所有的Exception
    public ModelAndView exception(Exception exception, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");// error页面
        // jsp页面中可以通过 ${errorMessage}获得设置的异常信息
        modelAndView.addObject("errorMessage", exception.getMessage());
        return modelAndView;
    }

    @ModelAttribute // 3.将键值对添加到全局,所有@RequestMapping的方法都可以获得此键值对
    public void addAttributes(Model model){
        model.addAttribute("msg", "额外信息");
    }

    @InitBinder // 4.定制WebDataBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id"); // 5.忽略request参数的id,更多关于WebDataBinder的配置参考其API文档
    }
}
