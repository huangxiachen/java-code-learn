package com.chx.service.impl;

import com.chx.dao.BookDaoInter;
import com.chx.dao.impl.BookDaoImpl;
import com.chx.service.BookServiceInter;

/**
 * @description://TODO
 * @author: Luck_chen
 * @date: 2023/4/18 21:46
 * @Version 1.0.0.0
 */
public class BookServiceImpl implements BookServiceInter {

    private BookDaoInter bookDao = new BookDaoImpl();
    public void save() {
        System.out.println("Service save");
        bookDao.save();
    }
}
