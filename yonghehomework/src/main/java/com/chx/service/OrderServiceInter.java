package com.chx.service;

import com.chx.pojo.Order;

import java.util.List;

/**
 * @description:
 * @author: Luck_chen
 * @date: 2023/4/18 11:58
 * @Version 1.0.0.0
 */
public interface OrderServiceInter {
    Order findOneOrder(Integer id);

    List<Order> list();

    boolean save(Order order);

    boolean update(Order order);

    boolean delete(Integer id);
}
