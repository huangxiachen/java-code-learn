package com;

import com.chx.dao.BookDaoInter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App4 {
    public static void main(String[] args) {
//        实例化bean通过构造方法创建
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDaoInter bookDao = (BookDaoInter) ctx.getBean("dao");
        bookDao.save();

        //通过静态工厂Factory创建实例化对象

    }
}
