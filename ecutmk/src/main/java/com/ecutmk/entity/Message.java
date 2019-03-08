package com.ecutmk.entity;

import java.sql.Timestamp;

/**
 * 实体类 User 与 t_users 表对应
 */
public class Message {
    private User user;
    private  Good good;
    private Timestamp M_date;
    private String M_content;
    private Integer M_id;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public Timestamp getM_date() {
        return M_date;
    }

    public void setM_date(Timestamp m_date) {
        M_date = m_date;
    }

    public String getM_content() {
        return M_content;
    }

    public void setM_content(String m_content) {
        M_content = m_content;
    }

    public Integer getM_id() {
        return M_id;
    }

    public void setM_id(Integer m_id) {
        M_id = m_id;
    }
}
