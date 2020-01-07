package com.briup.shopping.service.impl;

import com.briup.shopping.bean.ex.AmountEXl;
import com.briup.shopping.mapper.ex.AmountEXlMapper;
import com.briup.shopping.service.IAmountEXlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmountEXlServiceImpl implements IAmountEXlService {
    @Autowired
    private AmountEXlMapper amountEXlMapper;
    @Override
    public List<AmountEXl> findAll() throws RuntimeException {
        List<AmountEXl> list=amountEXlMapper.findAll();
        return list;
    }



}
