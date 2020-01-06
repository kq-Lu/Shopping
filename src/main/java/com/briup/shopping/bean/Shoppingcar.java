package com.briup.shopping.bean;

import java.io.Serializable;
import java.util.Date;

public class Shoppingcar implements Serializable {
    private Integer id;

    private Integer customerId;

    private Date ordertime;

    private Short ordercount;

    private Float saleprice;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Short getOrdercount() {
        return ordercount;
    }

    public void setOrdercount(Short ordercount) {
        this.ordercount = ordercount;
    }

    public Float getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(Float saleprice) {
        this.saleprice = saleprice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", customerId=").append(customerId);
        sb.append(", ordertime=").append(ordertime);
        sb.append(", ordercount=").append(ordercount);
        sb.append(", saleprice=").append(saleprice);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}