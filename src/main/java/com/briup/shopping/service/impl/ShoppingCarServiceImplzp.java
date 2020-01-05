package com.briup.shopping.service.impl;

import com.briup.shopping.bean.Shoppingcar;
import com.briup.shopping.bean.ex.ShoppingCarEXzp;
import com.briup.shopping.mapper.ShoppingcarMapper;
import com.briup.shopping.mapper.ex.ShoppingCarEXMapperzp;
import com.briup.shopping.service.IShoppingCarServicezp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCarServiceImplzp implements IShoppingCarServicezp {
    @Autowired
    private ShoppingcarMapper shoppingcarMapper;
    @Autowired
    private ShoppingCarEXMapperzp shoppingCarEXMapperzp;

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

    @Override
    public void deleteById(int id) throws RuntimeException {
        shoppingcarMapper.deleteByPrimaryKey(id);

    }

    @Override
    public List<ShoppingCarEXzp> findAll() throws RuntimeException {
        List<ShoppingCarEXzp> list= shoppingCarEXMapperzp.findAllShopping();
        return list;

    }


    @Override
    public ShoppingCarEXzp selectById(int id) throws RuntimeException {
        ShoppingCarEXzp shoppingCarEXzp = shoppingCarEXMapperzp.selectById(id);
        return shoppingCarEXzp;

    }
}
