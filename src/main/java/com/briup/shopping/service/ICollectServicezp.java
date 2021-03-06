package com.briup.shopping.service;

import com.briup.shopping.bean.Collect;
import com.briup.shopping.bean.ex.CollectEXzp;

import java.util.List;

public interface ICollectServicezp {
    void insert(int gid,int cid)throws RuntimeException;
    void deleteById(int id) throws RuntimeException;
    List<CollectEXzp> findAll() throws RuntimeException;
    List<CollectEXzp> findByWord(String word) throws RuntimeException;

}
