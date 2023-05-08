package com.chx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chx.pojo.Item;
import com.chx.service.ItemService;
import com.chx.dao.ItemMapper;
import com.chx.vo.EasyUITable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item>
    implements ItemService{

    @Resource
    ItemMapper itemMapper;

    @Override
    public EasyUITable queryByPage(Integer page, Integer rows) {
        int total = this.baseMapper.selectCount(new QueryWrapper<>());
        int start = (page-1)* rows;
        List<Item> itemList = itemMapper.queryByPage(start,rows);


        return new EasyUITable(total,itemList);
    }
}




