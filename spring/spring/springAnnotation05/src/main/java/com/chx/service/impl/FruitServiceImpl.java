package com.chx.service.impl;

import com.chx.service.FruitServiceInter;
import org.springframework.stereotype.Service;

/**
 * @description://TODO
 * @author: Luck_chen
 * @date: 2023/4/20 22:38
 * @Version 1.0.0.0
 */
@Service
public class FruitServiceImpl implements FruitServiceInter {
    @Override
    public void fruit() {
        System.out.println("FruitService init ....");
    }
}
