package com.briup.shopping.mapper.ex;

import com.briup.shopping.bean.ex.ForReceiveEX;

import java.util.List;

public interface ForReceiveEXMapper {
    List<ForReceiveEX> findForReceive(int status);
    void ReceiveGoods(int id);
}
