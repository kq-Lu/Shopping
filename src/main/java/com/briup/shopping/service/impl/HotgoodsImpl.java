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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class HotgoodsImpl implements IHotgoodsServiceg {
    @Autowired
    private GOMapper goMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<Goods> selectAll() {
        GoodsExample goodsExample = new GoodsExample();
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        List<Goods> goodsList = new ArrayList<>();
        for (Goods goods1 :goods){
            GOExample goExample = new GOExample();
            goExample.createCriteria().andGoodsIdEqualTo(goods1.getId());
            List<GO> go = goMapper.selectByExample(goExample);

            int sum = 0;
            for(GO go1 :go){
                sum += go1.getAmount();
            }
            if(sum > 20){
                goodsList.add(goodsMapper.selectByPrimaryKey(goods1.getId()));
            }
        }

        return goodsList;
    }
}
