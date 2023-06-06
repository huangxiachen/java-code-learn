package com.chx.controller;

import com.chx.pojo.ItemCat;
import com.chx.service.ItemCartService;
import com.chx.vo.EasyUITree;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("item/cat")
public class ItemCatController {

    @Resource
    private ItemCartService itemCartService;

    @PostMapping("/queryItemName")
    public String findItemById(@RequestParam  Long itemCatId){
        ItemCat name = itemCartService.findById(itemCatId);
        return name != null ? name.getName() : "";
    }

    @PostMapping("list")
    public List<EasyUITree> list(@RequestParam(name = "id",defaultValue = "0") Long parentId){
        return itemCartService.findEasyUiTree(parentId);
    }
}
