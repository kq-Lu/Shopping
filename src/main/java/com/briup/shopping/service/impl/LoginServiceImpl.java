package com.briup.shopping.service.impl;

import com.briup.shopping.bean.Customer;
import com.briup.shopping.bean.ex.CustomerEX;
import com.briup.shopping.mapper.ex.LoginEXMapper;
import com.briup.shopping.service.ILoginService;
import com.briup.shopping.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private LoginEXMapper loginEXMapper;

    @Override
    public CustomerEX login(String username, String password) throws RuntimeException {
        return loginEXMapper.login(username, password);
    }

    @Override
    public void insert(String username, String password, int phone, String address) {
        loginEXMapper.insert(username, password, phone, address);
    }
}
