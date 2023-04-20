package com.chx.dao.impl;

import com.chx.DataDaoInter;

public class DataDaoImpl implements DataDaoInter {
   private String driver;
   private String url;
   private String username;
   private String password;


    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void save() {
        String str =  "DataDaoImpl{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
        System.out.println(str);
    }
}
