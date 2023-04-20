package com.chx.service.impl;

import com.chx.service.UserServiceInter;

import java.util.*;

/**
 * @description://TODO
 * @author: Luck_chen
 * @date: 2023/4/20 15:28
 * @Version 1.0.0.0
 */
public class UserServiceImpl implements UserServiceInter {
    private Integer arr[] = new Integer[10];
    private Set<String> set;
    private List<String> list;
    private Map<String, String> map;
    private Properties pro;

    public UserServiceImpl() {
    }

    public Integer[] getArr() {
        return arr;
    }

    public void setArr(Integer[] arr) {
        this.arr = arr;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getPro() {
        return pro;
    }

    public void setPro(Properties pro) {
        this.pro = pro;
    }



    public void save() {
        System.out.println("init");
        System.out.println("UserServiceImpl{" +
                "arr=" + Arrays.toString(arr) +
                ", set=" + set +
                ", list=" + list +
                ", map=" + map +
                ", pro=" + pro +
                '}');
    }



}
