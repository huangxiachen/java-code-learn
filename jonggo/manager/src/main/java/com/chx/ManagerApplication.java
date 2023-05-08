package com.chx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chx.dao")
public class ManagerApplication{

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }
}
