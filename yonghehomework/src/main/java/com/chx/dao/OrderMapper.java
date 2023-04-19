package com.chx.dao;

import com.chx.pojo.Door;
import com.chx.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description://TODO
 * @author: Luck_chen
 * @date: 2023/4/18 10:13
 * @Version 1.0.0.0
 */
public interface OrderMapper {

    Order getDoorByOrderId(@Param("id") Integer id);

    List<Order> list();

    boolean save(Order order);


    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Order findOneOrderByPrimaryKey(Integer id);

}
