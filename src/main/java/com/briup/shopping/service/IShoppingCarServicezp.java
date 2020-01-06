package com.briup.shopping.service;

import com.briup.shopping.bean.Shoppingcar;
import com.briup.shopping.bean.ex.ShoppingCarEXzp;

import java.util.List;

public interface IShoppingCarServicezp {
    void saveOrUpdate(Shoppingcar shoppingcar) throws RuntimeException;
    void deleteById(int id) throws RuntimeException;
    void deleteBySId(int id) throws RuntimeException;
    List<ShoppingCarEXzp> findAll() throws RuntimeException;
    ShoppingCarEXzp  findById(int id) throws RuntimeException;
}
