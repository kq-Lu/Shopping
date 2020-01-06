package com.briup.shopping.service.impl;

import com.briup.shopping.bean.GOExample;
import com.briup.shopping.bean.Shoppingcar;
import com.briup.shopping.bean.ex.ShoppingCarEXzp;
import com.briup.shopping.mapper.GOMapper;
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
    private ShoppingCarEXMapperzp shoppingCarEXMapper;
    @Autowired
    private GOMapper goMapper;

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
        GOExample example=new GOExample();
        example.createCriteria().andShoppingcarIdEqualTo(id);
        goMapper.deleteByExample(example);
    }

    @Override
    public void deleteBySId(int id) throws RuntimeException {
        shoppingCarEXMapper.deleteBySId(id);
    }

    @Override
    public List<ShoppingCarEXzp> findAll() throws RuntimeException {
        List<ShoppingCarEXzp> list=shoppingCarEXMapper.findAll();
        return list;
    }

    @Override
    public ShoppingCarEXzp findById(int id) throws RuntimeException {
        ShoppingCarEXzp shoppingCarEXzp=shoppingCarEXMapper.findById(id);
        return shoppingCarEXzp;
    }


}
