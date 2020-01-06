package com.briup.shopping.service.impl;

import com.briup.shopping.bean.Shoppingcar;
import com.briup.shopping.mapper.ShoppingcarMapper;
import com.briup.shopping.service.IShoppingCarServicezp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCarServiceImplzp implements IShoppingCarServicezp {
    @Autowired
    private ShoppingcarMapper shoppingcarMapper;

    @Override
    public void saveOrUpdate(Shoppingcar shoppingcar) throws RuntimeException {
        if(shoppingcar==null){
            throw new RuntimeException("参数为空");
        }
        if(shoppingcar.getId()==null){
            shoppingcarMapper.insert(shoppingcar);
        }
        else{
            shoppingcarMapper.updateByPrimaryKey(shoppingcar);
        }

    }
}
