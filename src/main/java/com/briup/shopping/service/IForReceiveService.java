package com.briup.shopping.service;

import com.briup.shopping.bean.ex.ForReceiveEX;

import java.util.List;

public interface IForReceiveService {
    List<ForReceiveEX> findForReceive(String status) throws RuntimeException;

}
