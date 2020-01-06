package com.briup.shopping.mapper.ex;

import com.briup.shopping.bean.ex.SendGoodsEX;

import java.util.List;

public interface SendGoodsEXMapper {
    SendGoodsEX findSendGoods(int status);
    void SendOut(int id);
}
