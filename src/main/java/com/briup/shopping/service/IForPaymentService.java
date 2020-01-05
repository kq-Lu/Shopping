package com.briup.shopping.service;

import com.briup.shopping.bean.ex.ForPaymentEX;

import java.util.List;

public interface IForPaymentService {
    List<ForPaymentEX> findForPayment(String status) throws RuntimeException;
    void deleteOrderGO(int id) throws RuntimeException;
    void deleteMore(int[] ids) throws RuntimeException;

    void GoPayment(int id) throws RuntimeException;
}
