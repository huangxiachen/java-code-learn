package com.chx.service;

import com.chx.pojo.Item;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chx.vo.EasyUITable;

public interface ItemService extends IService<Item> {

    EasyUITable queryByPage(Integer page, Integer rows);

}
