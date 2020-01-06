package com.briup.shopping.bean.ex;

import com.briup.shopping.bean.Goods;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderEXg implements Serializable {
    private Integer code;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Double tprice;
    private String uname;
    private String address;
    private Integer phone;
    private String statu;
    private Date dates;

 private List<Goods> list;

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }



    public List<Goods> getList() {
        return list;
    }

    public void setList(List<Goods> list) {
        this.list = list;
    }



    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Double getTprice() {
        return tprice;
    }

    public void setTprice(Double tprice) {
        this.tprice = tprice;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }


}
