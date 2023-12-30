package com.hbnu.dao;

import com.hbnu.pojo.Goods;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author chendikai
 * @date 2023-04-11 9:14
 */
public interface GoodsDao {

    @Select("select * from tb_goods")
    public abstract List<Goods> findAllGoods();
}
