package com.briup.shopping.service.impl;

import com.briup.shopping.bean.ex.ForPaymentEX;
import com.briup.shopping.mapper.ex.ForPaymentEXMapper;
import com.briup.shopping.service.IForPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForPaymentServiceImpl implements IForPaymentService {

    @Autowired
    private ForPaymentEXMapper forPaymentEXMapper;
    @Override
    public List<ForPaymentEX> findForPayment(String status) throws RuntimeException {

        if ("待支付".equals(status)){
            return forPaymentEXMapper.findForPayment(3);

        }
        return null;
    }

//删除未支付的订单和关联表a_go
    @Override
    public void deleteOrderGO(int id) throws RuntimeException {
        forPaymentEXMapper.deleteOrder(id);
        forPaymentEXMapper.deleteGO(id);
    }

    @Override
    public void deleteMore(int[] ids) throws RuntimeException {
        for(int i=0;i<ids.length;i++){
            forPaymentEXMapper.deleteOrder(ids[i]);
            forPaymentEXMapper.deleteGO(ids[i]);
        }
    }

    @Override
    public void GoPayment(int id) throws RuntimeException {
        forPaymentEXMapper.GoPayment(id);
    }
}
