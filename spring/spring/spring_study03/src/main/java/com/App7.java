package com;

import com.chx.dao.BookDaoInter;
import com.chx.service.impl.BookServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App7 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        BookServiceImpl bookService = (BookServiceImpl) ctx.getBean("bookService");
//        bookService.save();
        BookServiceImpl bookService1 = (BookServiceImpl) ctx.getBean("bookService1");
        bookService1.save();
    }
}
