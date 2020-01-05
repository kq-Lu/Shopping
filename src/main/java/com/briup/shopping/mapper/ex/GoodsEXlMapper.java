package com.briup.shopping.mapper.ex;

import com.briup.shopping.bean.Goods;
import com.briup.shopping.bean.ex.GoodsEXl;

import java.util.List;

public interface GoodsEXlMapper {
    List<GoodsEXl> findAll();
    List<GoodsEXl> findByWord(String word,Integer price1,Integer price2);
    List<GoodsEXl> findByKey(String key);
    List<GoodsEXl> findByLowPrice(int price1);
    List<GoodsEXl> findByHighPrice(int price2);
    List<GoodsEXl> findByWlp(String word,Integer price1);
    List<GoodsEXl> findByWhp(String word,Integer price2);
    List<GoodsEXl> findByPrice(Integer price1,Integer price2);
    void SaveOrUpdate(Goods goods);

}
