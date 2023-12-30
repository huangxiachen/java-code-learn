package com.hbnu.service.impl;

import com.hbnu.dao.GoodsMapper;
import com.hbnu.pojo.Goods;
import com.hbnu.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chendikai
 * @date 2023-04-12 11:08
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> findAllGoods() {
        return goodsMapper.findAllGoods();
    }
}
