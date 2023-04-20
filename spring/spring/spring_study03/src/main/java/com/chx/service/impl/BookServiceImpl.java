package com.chx.service.impl;

import com.chx.dao.BookDaoInter;
import com.chx.service.BookServiceInter;

/**
 * @description://TODO
 * @author: Luck_chen
 * @date: 2023/4/18 21:46
 * @Version 1.0.0.0
 */
public class BookServiceImpl implements BookServiceInter {

    //删除业务层中使用的new出来的对象
//    private BookDaoInter bookDao = new BookDaoImpl();
    private BookDaoInter bookDao;
//    //提供setter方法来注入依赖
//    public void setBookDao(BookDaoInter bookDao) {
//        this.bookDao = bookDao;
//    }
    //构造器注入依赖
    private String bookName;
    private Double bookPrice;

    //引用类型使用构造器注入依赖


    public BookServiceImpl() {
    }

    public BookServiceImpl(BookDaoInter bookDao) {
        this.bookDao = bookDao;
    }

    public BookServiceImpl(String bookName, Double bookPrice) {

        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }

    public void save() {
        System.out.println("Service save");
        bookDao.save();
    }
}
