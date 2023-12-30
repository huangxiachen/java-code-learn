package com.hbnu.service;

import com.hbnu.pojo.Goods;

import java.util.List;

/**
 * @author chendikai
 * @date 2023-04-11 9:25
 */
public interface GoodsService {

    public abstract List<Goods> findAllGoods();
}
