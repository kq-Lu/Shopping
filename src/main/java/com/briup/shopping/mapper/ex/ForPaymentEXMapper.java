package com.briup.shopping.mapper.ex;

import com.briup.shopping.bean.ex.ForPaymentEX;

import java.util.List;

public interface ForPaymentEXMapper {
    List<ForPaymentEX> findForPayment(int status);
}
