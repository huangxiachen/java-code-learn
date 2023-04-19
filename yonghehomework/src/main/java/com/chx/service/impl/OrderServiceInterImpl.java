package com.chx.service.impl;

import com.chx.dao.OrderMapper;
import com.chx.pojo.Order;
import com.chx.service.OrderServiceInter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description://TODO
 * @author: Luck_chen
 * @date: 2023/4/18 12:01
 * @Version 1.0.0.0
 */
@Service("OrderServiceInterImpl")
public class OrderServiceInterImpl implements OrderServiceInter {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public Order findOneOrder(Integer id) {
        return orderMapper.getDoorByOrderId(id);
    }

    @Override
    public List<Order> list() {
        return orderMapper.list();
    }

    @Override
    public boolean save(Order order) {
        return orderMapper.insertSelective(order) > 0;
    }

    @Override
    public boolean update(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return orderMapper.deleteByPrimaryKey(id) > 0;
    }


}
