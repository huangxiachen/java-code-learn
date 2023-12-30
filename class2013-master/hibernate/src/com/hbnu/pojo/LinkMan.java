package com.hbnu.pojo;

/**
 * @author chendikai
 * @date 2023-03-08 10:12
 */
public class LinkMan {
    private int lid;  // 联系人id
    private String name; // 联系人姓名
    private String tel;  // 联系人电话
    private String gender;  // 联系人性别

    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
