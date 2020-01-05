package com.briup.shopping.service;

import com.briup.shopping.bean.ex.SendGoodsEX;

import java.util.List;

public interface ISendGoodsService {
    List<SendGoodsEX> findSendGoods(String status) throws RuntimeException;

    void SendOut(int id) throws RuntimeException;
}
