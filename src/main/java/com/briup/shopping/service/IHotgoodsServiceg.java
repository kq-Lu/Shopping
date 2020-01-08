package com.briup.shopping.service;

import com.briup.shopping.bean.Goods;

import java.util.List;

public interface IHotgoodsServiceg {
    List<Goods> selectAll() throws RuntimeException;
}
