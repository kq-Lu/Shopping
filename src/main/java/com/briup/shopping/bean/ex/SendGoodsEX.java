package com.briup.shopping.bean.ex;

import java.io.Serializable;
import java.util.Date;

public class SendGoodsEX implements Serializable {
    private int id;
    private String goodsName;
    private double totalPrice;
    private String userName;
    private String address;
    private int phone;
    private String expressMethod;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getExpressMethod() {
        return expressMethod;
    }

    public void setExpressMethod(String expressMethod) {
        this.expressMethod = expressMethod;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
