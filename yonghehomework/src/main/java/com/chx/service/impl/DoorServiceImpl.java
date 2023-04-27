package com.chx.service.impl;

import com.chx.dao.DoorMapper;
import com.chx.dao.OrderMapper;
import com.chx.pojo.Door;
import com.chx.service.DoorServiceInter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description://TODO
 * @author: Luck_chen
 * @date: 2023/4/18 14:19
 * @Version 1.0.0.0
 */
@Service("DoorServiceImpl")
public class DoorServiceImpl implements DoorServiceInter {

    @Resource
    DoorMapper doorMapper;

    @Resource
    OrderMapper orderMapper;

    public List<Door> list() {
       return doorMapper.list();
    }

    @Override
    public boolean delete(Integer id) {
        int count = orderMapper.countByDoorId(id);
        if (count  > 0){
            throw new RuntimeException("门店与其他订单相关联");
        }
        return doorMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public Door getOne(Integer id) {
        return doorMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateOrAdd(Door door) {
        if (door.getId() != null){
            return doorMapper.updateByPrimaryKeySelective(door) > 0;
        }else {
            return doorMapper.insertSelective(door) > 0;
        }
    }
}
