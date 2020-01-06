package com.briup.shopping.mapper.ex;

import com.briup.shopping.bean.ex.ShoppingCarEXzp;

import java.util.List;

public interface ShoppingCarEXMapperzp {
    void deleteBySId(int id);



    ShoppingCarEXzp findById(int id);

    List<ShoppingCarEXzp> findAll();
}
