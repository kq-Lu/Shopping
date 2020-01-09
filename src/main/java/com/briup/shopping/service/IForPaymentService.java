package com.briup.shopping.service;

import com.alipay.api.AlipayApiException;
import com.briup.shopping.bean.ex.ForPaymentEX;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface IForPaymentService {
    List<ForPaymentEX> findForPayment(String status) throws RuntimeException;
    void deleteOrderGO(int id) throws RuntimeException;
    void deleteMore(int[] ids) throws RuntimeException;

    void GoPayment(HttpServletResponse response, HttpServletRequest request, int id) throws RuntimeException;
    String Callback(HttpServletResponse response, HttpServletRequest request) throws RuntimeException, IOException, AlipayApiException, InterruptedException;
}
