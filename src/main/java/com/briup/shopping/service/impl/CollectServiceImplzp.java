package com.briup.shopping.service.impl;

import com.briup.shopping.bean.Collect;
import com.briup.shopping.bean.ex.CollectEXzp;
import com.briup.shopping.mapper.CollectMapper;
import com.briup.shopping.mapper.ex.CollectEXMapperzp;
import com.briup.shopping.service.ICollectServicezp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImplzp implements ICollectServicezp {
    @Autowired
    private CollectMapper collectMapper;
    @Autowired
    private CollectEXMapperzp collectEXMapperzp;

    @Override
    public void saveOrUpdate(Collect collect) throws RuntimeException {
        if(collect==null){
            throw new RuntimeException("参数为空");
        }
        if(collect.getId()==null){
           collectMapper.insert(collect);
        }
        else
        {
            collectMapper.updateByPrimaryKey(collect);
        }
    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        collectMapper.deleteByPrimaryKey(id);

    }

    @Override
    public List<CollectEXzp> findAll() throws RuntimeException {
        List<CollectEXzp> list=collectEXMapperzp.findAllCollect();
        return list;
    }

    @Override
    public List<CollectEXzp> findByWord(String word) throws RuntimeException {
       word= word == null ? "" : word;
       if(word==null||"".equals(word)){
           return collectEXMapperzp.findAllCollect();
       }
       else{
           word ="%" + word + "%" ;
           return collectEXMapperzp.findByWord(word);
       }
    }


}
