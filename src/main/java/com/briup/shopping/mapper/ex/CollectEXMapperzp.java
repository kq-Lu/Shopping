package com.briup.shopping.mapper.ex;

import com.briup.shopping.bean.ex.CollectEXzp;

import java.util.List;

public interface CollectEXMapperzp {
    List<CollectEXzp> findAllCollect();

    List<CollectEXzp> findByWord(String word);

    CollectEXzp findById(int id);
}
