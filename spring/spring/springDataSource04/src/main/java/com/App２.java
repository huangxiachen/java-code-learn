package com;

import com.chx.DataDaoInter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class App２ {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataDaoInter dataDao = (DataDaoInter) ctx.getBean("dataDao");
        dataDao.save();
    }
}
