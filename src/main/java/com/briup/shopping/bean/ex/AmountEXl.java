package com.briup.shopping.bean.ex;


import com.briup.shopping.bean.Goods;
import com.briup.shopping.bean.Order;

import java.io.Serializable;
import java.util.List;

public class AmountEXl implements Serializable {

    private String statusorders;
    List<Order> orders;
    List<Goods> goods;

    List<ResultEXl> goodsList;

    public List<ResultEXl> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<ResultEXl> goodsList) {
        this.goodsList = goodsList;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public String getStatusorders() {
        return statusorders;
    }

    public void setStatusorders(String statusorders) {
        this.statusorders = statusorders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }


}
