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
}
