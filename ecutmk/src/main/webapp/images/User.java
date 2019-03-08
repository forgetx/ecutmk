package com.ecutmk.entity;

/**
 * 实体类 User 与 t_users 表对应
 */
public class User {

    private Integer id ; //  int ==> Integer
    private String username ;
    private String password ;
    private String phone ;

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

    public Integer getUser_count_msg() {
        return user_count_msg;
    }

    public void setUser_count_msg(Integer user_count_msg) {
        this.user_count_msg = user_count_msg;
    }

    private Integer user_count_msg;//留言数


}
