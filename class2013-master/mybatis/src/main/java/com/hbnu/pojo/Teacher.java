package com.hbnu.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chendikai
 * @date 2023-03-29 10:12
 */
public class Teacher {
    private int tid;
    private String tname;

    Set<Classes> classes = new HashSet<>();

    public Set<Classes> getClasses() {
        return classes;
    }

    public void setClasses(Set<Classes> classes) {
        this.classes = classes;
    }
// private Classes classes;

    // public Classes getClasses() {
    //     return classes;
    // }

    // public void setClasses(Classes classes) {
    //     this.classes = classes;
    // }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", classes=" + classes +
                '}';
    }
}
