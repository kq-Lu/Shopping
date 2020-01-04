package com.briup.shopping.bean;

import java.io.Serializable;

public class GS implements Serializable {
    private Integer id;

    private Integer goodsId;

    private Integer shoppingcarId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getShoppingcarId() {
        return shoppingcarId;
    }

    public void setShoppingcarId(Integer shoppingcarId) {
        this.shoppingcarId = shoppingcarId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", shoppingcarId=").append(shoppingcarId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}