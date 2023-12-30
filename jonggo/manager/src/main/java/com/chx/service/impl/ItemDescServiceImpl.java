package com.chx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chx.pojo.ItemDesc;
import com.chx.service.ItemDescService;
import com.chx.dao.ItemDescMapper;
import org.springframework.stereotype.Service;


@Service
public class ItemDescServiceImpl extends ServiceImpl<ItemDescMapper, ItemDesc>
    implements ItemDescService{

}




