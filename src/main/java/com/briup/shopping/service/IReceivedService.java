package com.briup.shopping.service;

import com.briup.shopping.bean.Comment;
import com.briup.shopping.bean.ex.ReceivedEX;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IReceivedService {
    List<ReceivedEX> findReceived(String status) throws RuntimeException;
    void deleteReceivedGOComment(int id) throws RuntimeException;

    void deleteMoreReceivedGOComment(int[] ids) throws RuntimeException;

    void insertDescription(Comment comment) throws RuntimeException;

    void deleteDescription(int id) throws RuntimeException;
}
