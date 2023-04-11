package com.chx.service.impl;

import com.chx.dao.GoodsDao;
import com.chx.pojo.Goods;
import com.chx.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    GoodsDao goodsDao;

    @Override
    public List<Goods> getList() {
        return goodsDao.findAllGoods();
    }
}
