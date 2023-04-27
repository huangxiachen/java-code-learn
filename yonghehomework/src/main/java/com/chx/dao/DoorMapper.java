package com.chx.dao;

import com.chx.pojo.Door;

import java.util.List;

/**
 * @description://TODO
 * @author: Luck_chen
 * @date: 2023/4/18 10:13
 * @Version 1.0.0.0
 */
public interface DoorMapper {

    List<Door> list();

    int deleteByPrimaryKey(Integer id);

    int insert(Door record);

    int insertSelective(Door record);

    Door selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Door record);

    int updateByPrimaryKey(Door record);

    int count(Door dc);
}
