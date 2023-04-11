package com.chx.controller;

import com.chx.service.GoodsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description://TODO
 * @author: Luck_chen
 * @date: 2023/4/11 21:34
 * @Version 1.0.0.0
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    GoodsService goodsService;

    @GetMapping("list")
    public Object getList(){
        return goodsService.getList();
    }
}
