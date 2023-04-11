package com.chx.dao;

import com.chx.pojo.Goods;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author chendikai
 * @date 2023-04-10 9:24
 */
public interface GoodsDao {

    @Select("select * from tb_goods")
    public abstract List<Goods> findAllGoods();
}
