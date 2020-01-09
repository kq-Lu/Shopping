package com.briup.shopping.mapper.ex;

import com.briup.shopping.bean.GO;
import com.briup.shopping.bean.ex.ShoppingCarEXzp;

import java.util.List;

public interface ShoppingCarEXMapperzp {
    
    
    ShoppingCarEXzp findById(int id);

    List<ShoppingCarEXzp> findAll();

    void deleteById(int id);

    void deleteorderIntm(int sid,int oid);

    GO selectBygIdandsid(int gid,int sid);

    void insert(int gid,int sid);

    void update1(int amount,int id);

    void updatecomment();

    void deleteBygo(int sid, int oid);
}
