package com.ecutmk.entity;

import java.io.File;
import java.sql.Blob;

public class Good {
    private Integer good_id;//商品id
    private Integer good_owner;//商品拥有者id
    private String good_kind;//商品种类
    private String good_summary;//商品价格
    private String good_explain;//商品简介
    private double good_price;//商品详解
    private Blob good_picture1;//商品图片第一张
    private Blob good_picture2;//商品图片第二张
    private Blob good_picture3;//商品图片第三张
    private Blob good_picture4;//商品图片第四张

    public Integer getGood_id() {
        return good_id;
    }

    public void setGood_id(Integer good_id) {
        this.good_id = good_id;
    }

    public Integer getGood_owner() {
        return good_owner;
    }

    public void setGood_owner(Integer good_owner) {
        this.good_owner = good_owner;
    }

    public String getGood_kind() {
        return good_kind;
    }

    public void setGood_kind(String good_kind) {
        this.good_kind = good_kind;
    }

    public String getGood_summary() {
        return good_summary;
    }

    public void setGood_summary(String good_summary) {
        this.good_summary = good_summary;
    }

    public String getGood_explain() {
        return good_explain;
    }

    public void setGood_explain(String good_explain) {
        this.good_explain = good_explain;
    }

    public double getGood_price() {
        return good_price;
    }

    public void setGood_price(double good_price) {
        this.good_price = good_price;
    }

    public Blob getGood_picture1() {
        return good_picture1;
    }

    public void setGood_picture1(Blob good_picture1) {
        this.good_picture1 = good_picture1;
    }

    public Blob getGood_picture2() {
        return good_picture2;
    }

    public void setGood_picture2(Blob good_picture2) {
        this.good_picture2 = good_picture2;
    }

    public Blob getGood_picture3() {
        return good_picture3;
    }

    public void setGood_picture3(Blob good_picture3) {
        this.good_picture3 = good_picture3;
    }

    public Blob getGood_picture4() {
        return good_picture4;
    }

    public void setGood_picture4(Blob good_picture4) {
        this.good_picture4 = good_picture4;
    }
}
