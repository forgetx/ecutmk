package com.ecutmk.entity;

import javax.xml.soap.Text;
import java.sql.Timestamp;

public class Reply {
    private Integer r_id;//回复id
    private String r_user;//回复者
    private Integer r_m_id;//回复的留言对象
    private String  r_m_user;//回复留言的留言者
    private Integer r_good;//回复留言所在的商品
    private Timestamp r_date;//回复时间
    private String r_content;//回复内容

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public String getR_user() {
        return r_user;
    }

    public void setR_user(String r_user) {
        this.r_user = r_user;
    }

    public Integer getR_m_id() {
        return r_m_id;
    }

    public void setR_m_id(Integer r_m_id) {
        this.r_m_id = r_m_id;
    }

    public String getR_m_user() {
        return r_m_user;
    }

    public void setR_m_user(String r_m_user) {
        this.r_m_user = r_m_user;
    }

    public Integer getR_good() {
        return r_good;
    }

    public void setR_good(Integer r_good) {
        this.r_good = r_good;
    }

    public Timestamp getR_date() {
        return r_date;
    }

    public void setR_date(Timestamp r_date) {
        this.r_date = r_date;
    }

    public String getR_content() {
        return r_content;
    }

    public void setR_content(String r_content) {
        this.r_content = r_content;
    }
}
