package com.briup.shopping.service;

import com.briup.shopping.bean.ex.SendGoodsEX;

import java.util.List;

public interface ISendGoodsService {
    List<SendGoodsEX> findSendGoods(String status) throws RuntimeException;

    SendGoodsEX download(int id) throws RuntimeException;

    void sendOut(int id) throws RuntimeException;
}
