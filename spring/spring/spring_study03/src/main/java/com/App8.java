package com;

import com.chx.service.UserServiceInter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description://TODO
 * @author: Luck_chen
 * @date: 2023/4/20 15:24
 * @Version 1.0.0.0
 */
public class App8 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceInter userService = (UserServiceInter) ctx.getBean("userService");
        userService.save();
        System.out.println("111");
    }
}
