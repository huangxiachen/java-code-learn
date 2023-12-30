package com.hbnu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chendikai
 * @date 2023-04-12 10:06
 */
@Controller
// @RestController  // RestController注解是Controller注解和ResponseBody的组合
public class PageController {

    @RequestMapping("/{pageName}")
    // @ResponseBody
    public String page(@PathVariable String pageName) {
        return pageName;
    }
}
