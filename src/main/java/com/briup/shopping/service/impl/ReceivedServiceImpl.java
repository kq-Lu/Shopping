package com.briup.shopping.service.impl;

import com.briup.shopping.bean.ex.ReceivedEX;
import com.briup.shopping.mapper.ex.ReceivedEXMapper;
import com.briup.shopping.service.IReceivedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ReceivedServiceImpl implements IReceivedService {
    @Autowired
    private ReceivedEXMapper receivedEXMapper;
    @Override
    public List<ReceivedEX> findReceived(String status) throws RuntimeException {
        if ("已收货".equals(status)){
            List<ReceivedEX> list= receivedEXMapper.findReceived(4);
            System.out.println(list);
            return list;
        }
        return null;
    }
//删除订单以及相关的关联表a_go和评论a_comment
    @Override
    public void deleteReceivedGOComment(int id) throws RuntimeException {
        receivedEXMapper.deleteReceived(id);
        receivedEXMapper.deleteGO(id);
        receivedEXMapper.deleteComment(id);
    }

    @Override
    public void deleteMoreReceivedGOComment(int[] ids) throws RuntimeException {
        for (int i=0;i<ids.length;i++){
            receivedEXMapper.deleteReceived(ids[i]);
            receivedEXMapper.deleteGO(ids[i]);
            receivedEXMapper.deleteComment(ids[i]);
        }
    }


    @Override
    public void insertDescription(int id, Date date, String desc) throws RuntimeException {
        receivedEXMapper.insertDescription(id,date ,desc);
    }

    @Override
    public void deleteDescription(int id) throws RuntimeException {
        receivedEXMapper.deleteDescription(id);
    }
}
