package com.chx.controller;

import com.chx.service.ItemService;
import com.chx.vo.EasyUITable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("item")
public class ItemController {
    @Resource
    ItemService itemService;

    @GetMapping("query")
    public EasyUITable query(@RequestParam Integer page,Integer rows){
        return itemService.queryByPage(page,rows);
    }
}
