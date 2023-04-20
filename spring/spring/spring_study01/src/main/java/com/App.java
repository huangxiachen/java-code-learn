package com;

import com.chx.service.impl.BookServiceImpl;

/**
 * @description://TODO
 * @author: Luck_chen
 * @date: 2023/4/18 21:41
 * @Version 1.0.0.0
 */
public class App {
    public static void main(String[] args) {
        BookServiceImpl bookService = new BookServiceImpl();
        bookService.save();
    }
}
