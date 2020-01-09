package com.briup.shopping.bean.ex;

import java.io.Serializable;

public class GoEX implements Serializable {
    private Integer amount;

    private Integer shoppingcarId;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getShoppingcarId() {
        return shoppingcarId;
    }

    public void setShoppingcarId(Integer shoppingcarId) {
        this.shoppingcarId = shoppingcarId;
    }
}
