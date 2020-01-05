package com.briup.shopping.service;

import com.briup.shopping.bean.Goods;
import com.briup.shopping.bean.ex.GoodsEXl;

import java.util.List;

public interface IGoodsEXlService {
    List<GoodsEXl> findAll() throws RuntimeException;
    List<GoodsEXl> findByWord(String word,Integer p1,Integer p2) throws RuntimeException;
    void saveOrUpdate(Goods goods) throws RuntimeException;
    void deleteById(int id) throws RuntimeException;
}
