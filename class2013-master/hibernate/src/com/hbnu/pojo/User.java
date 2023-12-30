package com.hbnu.pojo;

/**
 * @author chendikai
 * @date 2023-02-21 8:40
 */
public class User {
    // hibernate要求类中要有唯一属性
    private int uid;
    private String username;
    private String address;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}