package com.chx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {

    //直接访问页面
    @RequestMapping("/{pageName}")
    public String page(@PathVariable String pageName) {
        return pageName;
    }
}
