package com.briup.shopping.mapper.ex;

import com.briup.shopping.bean.ex.OrderEXg;

import java.util.List;

public interface OrderEXgMapper {
    List<OrderEXg> findAll();
    OrderEXg selectById(int id);
    void updateTotalprice(double tprice,int id);
}
