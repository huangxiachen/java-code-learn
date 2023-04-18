package com.chx.service.impl;

import com.chx.dao.DoorMapper;
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

    public List<Door> list() {
       return doorMapper.list();
    }
}
