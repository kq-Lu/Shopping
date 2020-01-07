package com.briup.shopping.mapper.ex;

import com.briup.shopping.bean.Customer;
import com.briup.shopping.bean.ex.CustomerEX;

public interface LoginEXMapper {
    CustomerEX login(String username, String password);

    void insert(String username,String password,int phone,String address);
}
