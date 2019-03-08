package com.ecutmk.entity;

import java.sql.Timestamp;

public class Message {
    private Integer m_id;//留言id
    private String m_user;//留言者
    private Integer m_good;//被留言的商品
    private Timestamp m_date;//留言时间
    private String m_content;//留言内容

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public String getM_user() {
        return m_user;
    }

    public void setM_user(String m_user) {
        this.m_user = m_user;
    }

    public Integer getM_good() {
        return m_good;
    }

    public void setM_good(Integer m_good) {
        this.m_good = m_good;
    }

    public Timestamp getM_date() {
        return m_date;
    }

    public void setM_date(Timestamp m_date) {
        this.m_date = m_date;
    }

    public String getM_content() {
        return m_content;
    }

    public void setM_content(String m_content) {
        this.m_content = m_content;
    }
}
