package com.hbnu.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chendikai
 * @date 2023-03-08 10:11
 */
public class Customer {
    private int cid; // 客户id
    private String name;  // 客户名称
    private String address; // 客户地址

    Set<LinkMan> linkManSet = new HashSet<>();

    public Set<LinkMan> getLinkManSet() {
        return linkManSet;
    }

    public void setLinkManSet(Set<LinkMan> linkManSet) {
        this.linkManSet = linkManSet;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
