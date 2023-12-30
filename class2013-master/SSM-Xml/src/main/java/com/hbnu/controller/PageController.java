package com.hbnu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chendikai
 * @date 2023-04-12 11:23
 */
@Controller
public class PageController {

    @RequestMapping("/{pageName}")
    public String page(@PathVariable String pageName) {
        return pageName;
    }
}
