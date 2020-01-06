package com.briup.shopping.mapper.ex;

import com.briup.shopping.bean.ex.ReceivedEX;

import java.util.Date;
import java.util.List;

public interface ReceivedEXMapper {
    List<ReceivedEX> findReceived(int status);

    void deleteReceived(int id);
    void deleteGO(int id);
    void deleteComment(int id);

    void insertDescription(int id, Date date,String desc);
    void deleteDescription(int id);
}
