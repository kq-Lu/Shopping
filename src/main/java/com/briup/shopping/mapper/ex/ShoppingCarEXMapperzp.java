package com.briup.shopping.mapper.ex;

import com.briup.shopping.bean.ex.ShoppingCarEXzp;

import java.util.List;

public interface ShoppingCarEXMapperzp {
    List<ShoppingCarEXzp> findAllShopping();

    List<ShoppingCarEXzp> findByword(String word);

    ShoppingCarEXzp selectById(int id);
}
