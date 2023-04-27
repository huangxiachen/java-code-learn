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
        //有关联的不能删
        int count = orderMapper.countByDoorId(id);
        if (count  > 0){
            throw new RuntimeException("删除失败，门店与其他订单相关联");
        }
        return doorMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public Door getOne(Integer id) {
        return doorMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateOrAdd(Door door) {

        //根据有没有传主键来判断是更新还是新增
        if (door.getId() != null){
            return doorMapper.updateByPrimaryKeySelective(door) > 0;
        }else {
            //根据名称和地址去重
            Door dc = new Door();
            dc.setName(door.getName());
            dc.setAddr(door.getAddr());
            int count = doorMapper.count(dc);
            if (count > 0){
                throw new RuntimeException("当前地点门店已经存在,不能添加一个已存在的门店");
            }
            return doorMapper.insertSelective(door) > 0;
        }
    }
}
