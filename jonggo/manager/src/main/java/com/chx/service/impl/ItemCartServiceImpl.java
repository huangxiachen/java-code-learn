package com.chx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chx.dao.ItemCartMapper;
import com.chx.pojo.ItemCat;
import com.chx.service.ItemCartService;
import com.chx.vo.EasyUITree;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCartServiceImpl implements ItemCartService {

    @Resource
    ItemCartMapper itemCartMapper;


    @Override
    public ItemCat findById(Long itemCartId) {
        return itemCartMapper.selectById(itemCartId);
    }

    @Override
    public List<EasyUITree> findEasyUiTree(Long parentId) {
        List<ItemCat> byParentId = findByParentId(parentId);
        List<EasyUITree> result = new ArrayList<>();
        for (ItemCat itemCat : byParentId) {
            result.add(new EasyUITree(itemCat.getId(),itemCat.getName(),itemCat.getIsParent() ? "closed" : "open"));
        }
        return result;
    }

    public List<ItemCat> findByParentId(Long parentId){
        QueryWrapper<ItemCat> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(ItemCat::getParentId,parentId);
        return itemCartMapper.selectList(queryWrapper);
    }
}
