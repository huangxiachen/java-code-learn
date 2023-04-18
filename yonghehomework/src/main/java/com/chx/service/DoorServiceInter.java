package com.chx.service;

import com.chx.pojo.Door;

import java.util.List;

/**
 * @description://TODO
 * @author: Luck_chen
 * @date: 2023/4/18 14:18
 * @Version 1.0.0.0
 */
public interface DoorServiceInter {
    List<Door> list();

    boolean delete(Integer id);

    Door getOne(Integer id);

    boolean updateOrAdd(Door door);

}
