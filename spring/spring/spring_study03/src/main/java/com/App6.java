package com;

import com.chx.dao.BookDaoInter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App6 {
    public static void main(String[] args) {
        //提供生命周期方法和配置bean来测试生命周期
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDaoInter bookDao = (BookDaoInter) ctx.getBean("bookDao");
        bookDao.save();
        //设置关闭钩子，位置随意
//        ctx.registerShutdownHook();
        ctx.close();//关闭容器，方式暴力，不推荐




    }
}
