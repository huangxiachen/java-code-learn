package com.chx.dao.impl;

import com.chx.dao.BookDaoInter;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


/**
 * @description://TODO
 * @author: Luck_chen
 * @date: 2023/4/18 21:44
 * @Version 1.0.0.0
 */
//实现接口
public class BookDaoImpl implements BookDaoInter, InitializingBean, DisposableBean {

    public BookDaoImpl() {
        System.out.println("constructor.....");
    }

////    提供生命周期方法
//    public void init1(){
//        System.out.println("book dao init.....");
//    }
//
//    public void destroy(){
//        System.out.println("book dao destroy....");
//    }

    public void save() {
        System.out.println("dao save");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("book dao destroy....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("book dao init....");
    }
}
