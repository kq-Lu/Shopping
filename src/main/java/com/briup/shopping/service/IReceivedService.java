package com.briup.shopping.service;

import com.briup.shopping.bean.ex.ReceivedEX;

import java.util.Date;
import java.util.List;

public interface IReceivedService {
    List<ReceivedEX> findReceived(String status) throws RuntimeException;
    void deleteReceivedGOComment(int id) throws RuntimeException;

    void deleteMoreReceivedGOComment(int[] ids) throws RuntimeException;

    void insertDescription(int id, Date date,String desc) throws RuntimeException;

    void deleteDescription(int id) throws RuntimeException;
}
