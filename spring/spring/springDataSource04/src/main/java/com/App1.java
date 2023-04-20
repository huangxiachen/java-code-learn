package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class App1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println(dataSource);
        DataSource c3p0DataSource = (DataSource) ctx.getBean("c3p0DataSource");
        System.out.println(c3p0DataSource);
    }
}
