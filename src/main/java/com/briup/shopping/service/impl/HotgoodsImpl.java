package com.briup.shopping.service.impl;

import com.briup.shopping.bean.GO;
import com.briup.shopping.bean.GOExample;
import com.briup.shopping.bean.Goods;
import com.briup.shopping.bean.GoodsExample;
import com.briup.shopping.mapper.GOMapper;
import com.briup.shopping.mapper.GoodsMapper;
import com.briup.shopping.mapper.OrderMapper;
import com.briup.shopping.mapper.ex.GoodsEXgMapper;
import com.briup.shopping.mapper.ex.OrderEXgMapper;
import com.briup.shopping.service.IHotgoodsServiceg;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HotgoodsImpl implements IHotgoodsServiceg {
    @Autowired
    private OrderEXgMapper orderEXgMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private GOMapper goMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsEXgMapper goodsEXgMapper;
    @Override
    public List<Goods> selectAll() {
        int sum=0;
        Goods goods = new Goods();
        GOExample goExample = new GOExample();
        GO go1 = new GO();
        List<GO> listgo=goMapper.selectByExample(goExample);
        for(GO go:listgo){
            goExample.createCriteria().andGoodsIdEqualTo(goods.getId());
            sum+=go1.getAmount();
        }
        return null;
    }
}
