package com.chx.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.chx.pojo.Item;
import com.chx.pojo.ItemDesc;
import com.chx.service.ItemCartService;
import com.chx.service.ItemDescService;
import com.chx.service.ItemService;
import com.chx.vo.EasyUITable;
import com.chx.vo.SysResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;

@RestController
@RequestMapping("item")
public class ItemController {
    @Resource
    ItemService itemService;

    @Resource
    ItemDescService itemDescService;

    @GetMapping("query")
    public EasyUITable query(@RequestParam Integer page,@RequestParam Integer rows){
        return itemService.queryByPage(page,rows);
    }

    @PostMapping("save")
    @Transactional
    public SysResult save(Item item, ItemDesc itemDesc){
        item.setStatus(1).setCreated(new Date()).setUpdated(item.getCreated());
        itemService.save(item);
        itemDesc.setItemId(item.getId()).setCreated(item.getCreated()).setUpdated(item.getCreated());
        itemDescService.save(itemDesc);
        return SysResult.success();
    }

    @PostMapping("update")
    public SysResult update(Item item){
        item.setUpdated(new Date());
        itemService.updateById(item);
        return SysResult.success();
    }

    @PostMapping("delete")
    public SysResult delete(Long[] ids){
        itemService.removeByIds(Arrays.asList(ids));
        return SysResult.success();
    }

    @PostMapping("instock")
    public SysResult instock(Long[] ids){
        Item item = new Item();
        item.setStatus(2);
        UpdateWrapper<Item> wrapper = new UpdateWrapper<>();
        wrapper.lambda().in(Item::getId,ids);

        itemService.update(item,wrapper);
        return SysResult.success();
    }

    @PostMapping("reshelf")
    public SysResult reshelf(Long[] ids){
        Item item = new Item();
        item.setStatus(1);
        UpdateWrapper<Item> wrapper = new UpdateWrapper<>();
        wrapper.lambda().in(Item::getId,ids);

        itemService.update(item,wrapper);
        return SysResult.success();
    }

    @GetMapping("/query/item/desc/{itemId}")
    public SysResult findItemDesc(@PathVariable Long itemId){
        ItemDesc byId = itemDescService.getById(itemId);
        return SysResult.success(byId);
    }
}
