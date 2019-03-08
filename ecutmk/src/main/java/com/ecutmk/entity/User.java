package com.ecutmk.entity;

/**
 * 实体类 User 与 t_users 表对应
 */
public class User {

    private Integer id ; //  int ==> Integer
    private String username ;
    private String password ;
    private String phone ;
    private Integer count_msg;
    private Integer count_good;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCount_msg() {
        return count_msg;
    }

    public void setCount_msg(Integer count_msg) {
        this.count_msg = count_msg;
    }

    public Integer getCount_good() {
        return count_good;
    }

    public void setCount_good(Integer count_good) {
        this.count_good = count_good;
    }
}
