package com.briup.shopping.bean.ex;

import com.briup.shopping.bean.Goods;

import java.io.Serializable;
import java.util.List;

public class ShoppingCarEXzp implements Serializable {

    private Integer id;

    List<Goods> goods;

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }



    private String cname;
    private Integer count;
    private Double totalprice;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }




}
