package com.briup.shopping.service;

import com.briup.shopping.bean.ex.AmountEXl;
import com.briup.shopping.bean.ex.ResultEXl;

import java.util.List;

public interface IAmountEXlService {
    List<AmountEXl> findAll() throws RuntimeException;
}
