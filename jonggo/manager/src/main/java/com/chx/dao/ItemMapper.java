package com.chx.dao;

import com.chx.pojo.Item;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemMapper extends BaseMapper<Item> {

    List<Item> queryByPage(@Param("start") int start, @Param("rows") Integer rows);

}




