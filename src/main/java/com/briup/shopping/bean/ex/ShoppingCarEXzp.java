package com.briup.shopping.bean.ex;

import com.briup.shopping.bean.Goods;

import java.io.Serializable;
import java.util.List;

public class ShoppingCarEXzp implements Serializable {
    private Integer id;

    private String cname;

    List<GoodsEXzp1> goods;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<GoodsEXzp1> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsEXzp1> goods) {
        this.goods = goods;
    }
}
