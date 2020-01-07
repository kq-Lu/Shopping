package com.briup.shopping.service;

import com.briup.shopping.bean.Customer;
import com.briup.shopping.bean.ex.CustomerEX;

public interface ILoginService {
    CustomerEX login(String username, String password) throws RuntimeException;

    void insert(String username,String password,int phone,String address);
}
