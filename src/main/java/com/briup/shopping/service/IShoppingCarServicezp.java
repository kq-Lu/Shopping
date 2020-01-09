package com.briup.shopping.service;

import com.briup.shopping.bean.GO;
import com.briup.shopping.bean.Shoppingcar;
import com.briup.shopping.bean.ex.ShoppingCarEXzp;

import java.util.List;

public interface IShoppingCarServicezp {
    //添加购物车
    void insert(Shoppingcar shoppingcar) throws RuntimeException;
    //删除某一个购物车时删除下面所有的订单项
    void deleteById(int id) throws RuntimeException;
    //删除某一个购物车指定的某一个订单项
    void deletego(int sid,int oid) throws RuntimeException;
    //查询所有购物车的商品列表
    List<ShoppingCarEXzp> findAll() throws RuntimeException;
    //根据id查询某一个购物车的商品列表
    ShoppingCarEXzp  findById(int id) throws RuntimeException;
    //往购物车中添加商品
    void saveOrUpdate(int gid,int sid) throws RuntimeException;
}
