package com.briup.shopping.service;

import com.briup.shopping.bean.ex.ForPaymentEX;

public interface IForPaymentService {
    ForPaymentEX findForPayment(String status) throws RuntimeException;
}
