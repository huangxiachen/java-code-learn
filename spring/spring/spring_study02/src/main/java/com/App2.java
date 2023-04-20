package com;

import com.chx.dao.BookDaoInter;
import com.chx.dao.impl.BookDaoImpl;
import com.chx.service.BookServiceInter;
import com.chx.service.impl.BookServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description://TODO
 * @author: Luck_chen
 * @date: 2023/4/18 21:41
 * @Version 1.0.0.0
 */
public class App2 {
    public static void main(String[] args) {
       //3.获取Ioc容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //4.获取bean
        BookServiceInter bookDaoService = (BookServiceInter) ctx.getBean("bookDaoService");
        bookDaoService.save();


    }
}
