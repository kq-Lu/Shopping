package com.briup.shopping.mapper.ex;

import com.briup.shopping.bean.ex.SendGoodsEX;

import java.util.List;

public interface SendGoodsEXMapper {
    List<SendGoodsEX> findSendGoods(int status);

    SendGoodsEX download(int id);

    void SendOut(int id);
}
