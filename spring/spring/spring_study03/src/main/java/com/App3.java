package com;

import com.chx.dao.BookDaoInter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description://TODO
 * @author: Luck_chen
 * @date: 2023/4/18 21:41
 * @Version 1.0.0.0
 */
public class
App3 {
    public static void main(String[] args) {
        //3.获取Ioc容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        //4.获取bean
//        BookServiceInter bookDaoService = (BookServiceInter) ctx.getBean("bookDaoService");
//        bookDaoService.save();

        BookDaoInter bookDao1 = (BookDaoInter) ctx.getBean("bookDao");
        BookDaoInter bookDao2 = (BookDaoInter) ctx.getBean("dao");

        //非单例创建bean 的地址值不一样
        System.out.println(bookDao1);
        System.out.println(bookDao2);

    }
}
