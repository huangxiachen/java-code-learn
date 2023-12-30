package com.hbnu.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chendikai
 * @date 2023-03-29 10:12
 */
public class Classes {
    private int cid;
    private String cname;

    Set<Teacher> teachers = new HashSet<>();

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
// private Teacher teacher;

    // public Teacher getTeacher() {
    //     return teacher;
    // }

    // public void setTeacher(Teacher teacher) {
    //     this.teacher = teacher;
    // }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", teachers=" + teachers +
                '}';
    }
}
