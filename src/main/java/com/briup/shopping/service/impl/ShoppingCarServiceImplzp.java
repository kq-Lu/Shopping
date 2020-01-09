package com.briup.shopping.service.impl;

import com.briup.shopping.bean.*;
import com.briup.shopping.bean.ex.ShoppingCarEXzp;
import com.briup.shopping.mapper.CommentMapper;
import com.briup.shopping.mapper.GOMapper;
import com.briup.shopping.mapper.ShoppingcarMapper;
import com.briup.shopping.mapper.ex.GoEXMapper;
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
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private GoEXMapper goEXMapper;

    @Override
    public void insert(Shoppingcar shoppingcar) throws RuntimeException {
        if(shoppingcar==null){
            throw new RuntimeException("参数为空");
        }
        if(shoppingcar.getId()==null){
            shoppingcarMapper.insert(shoppingcar);
        }
        //else{
            //shoppingcarMapper.updateByPrimaryKey(shoppingcar);
       // }

    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        //删除某一个购物车时删除该购物车中的所有订单项
        shoppingCarEXMapper.deleteById(id);
        GOExample example = new GOExample();
        example.createCriteria().andShoppingcarIdEqualTo(id);
        goMapper.deleteByExample(example);
        shoppingcarMapper.deleteByPrimaryKey(id);


    }

    @Override
    public void deletego(int sid,int oid) throws RuntimeException {
        //删除某一个购物车中的指定的一个订单项
        shoppingCarEXMapper.deleteBygo(sid,oid);


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

    @Override
    public void saveOrUpdate(int gid,int sid) throws RuntimeException {
       GO go=shoppingCarEXMapper.selectBygIdandsid(gid,sid);
       if(go==null||"".equals(go)){
           shoppingCarEXMapper.insert(gid, sid);
       }
       else{
           //go.setAmount(go.getAmount()+1);
           //System.out.println(go.getAmount());
           shoppingCarEXMapper.update1(go.getAmount()+1,go.getId());
           }
       }




    }



