package com.briup.shopping.service.impl;

import com.briup.shopping.bean.ex.ForReceiveEX;
import com.briup.shopping.mapper.ex.ForReceiveEXMapper;
import com.briup.shopping.service.IForReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ForReceiveServiceImpl implements IForReceiveService {

    @Autowired
    private ForReceiveEXMapper forReceiveEXMapper;
    @Override
    public List<ForReceiveEX> findForReceive(String status) throws RuntimeException {
        if ("待收货".equals(status)){
            return forReceiveEXMapper.findForReceive(1);
        }
        return null;
    }

    @Override
    public void ReceiveGoods(int id) throws RuntimeException {
        forReceiveEXMapper.ReceiveGoods(id);
    }
}
