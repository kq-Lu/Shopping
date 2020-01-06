package com.briup.shopping.service.impl;

import com.briup.shopping.bean.ex.SendGoodsEX;
import com.briup.shopping.mapper.ex.SendGoodsEXMapper;
import com.briup.shopping.service.ISendGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendGoodsServiceImpl implements ISendGoodsService {

    @Autowired
    private SendGoodsEXMapper sendGoodsEXMapper;
    @Override
    public SendGoodsEX findSendGoods(String status) throws RuntimeException {
        if ("待发货".equals(status)){
            return sendGoodsEXMapper.findSendGoods(2);
        }
        return null;
    }

    @Override
    public void SendOut(int id) throws RuntimeException {
        sendGoodsEXMapper.SendOut(id);
    }
}
