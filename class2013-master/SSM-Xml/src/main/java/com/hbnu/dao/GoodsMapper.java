package com.hbnu.dao;

import com.hbnu.pojo.Goods;

import java.util.List;

/**
 * @author chendikai
 * @date 2023-04-12 11:08
 */
public interface GoodsMapper {

    List<Goods> findAllGoods();

}
