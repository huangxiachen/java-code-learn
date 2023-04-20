package com.chx.dao.impl;

import com.chx.dao.FruitDaoInter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @description://TODO
 * @author: Luck_chen
 * @date: 2023/4/20 22:30
 * @Version 注解开发定义Bean
 */

@Repository("fruitDao")
public class FruitDaoImpl implements FruitDaoInter {
    private FruitDaoInter fruitDao;

    @Override
    public void fruit() {
        System.out.println("FruitDao init....");
    }
}
