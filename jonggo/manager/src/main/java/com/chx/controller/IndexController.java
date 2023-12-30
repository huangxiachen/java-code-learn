package com.chx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping("/page/{moduleName}")
    public ModelAndView pageModuleName(@PathVariable String moduleName){
        ModelAndView modelAndView = new ModelAndView(moduleName);
        return modelAndView;
    }

    @RequestMapping("/page/{pageName}")
    public String page(@PathVariable String pageName){
        return pageName;
    }
}
