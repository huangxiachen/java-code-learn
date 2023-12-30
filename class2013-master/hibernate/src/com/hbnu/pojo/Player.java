package com.hbnu.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chendikai
 * @date 2023-03-14 8:32
 */
public class Player {
    private int pid;  // 玩家id
    private String name;  // 玩家名字
    private String gender;  // 玩家性别

    Set<Role> roles = new HashSet<>();

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
