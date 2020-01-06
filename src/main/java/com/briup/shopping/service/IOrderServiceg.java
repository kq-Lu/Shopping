package com.briup.shopping.service;

import com.briup.shopping.bean.Order;
import com.briup.shopping.bean.ex.OrderEXg;

import java.util.List;

public interface IOrderServiceg {
    List<OrderEXg> findAllOrder() throws RuntimeException;
    void  deleteById(int id) throws  RuntimeException;
    void saveOrupdate(Order order)throws RuntimeException;
    OrderEXg selectById(int id) throws RuntimeException;
    void totalPrice() throws RuntimeException;

}
