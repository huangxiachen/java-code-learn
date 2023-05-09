package com.chx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {

    //访问对应页面的路径，有了这个方法才能访问配置好的视图
    @RequestMapping("/{pageName}")
    public String page(@PathVariable String pageName) {
        return pageName;
    }
}
