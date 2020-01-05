package com.briup.shopping.mapper.ex;

import com.briup.shopping.bean.Customer;

import java.util.List;

public interface CustomerlMapper {
    List<Customer> findAll();
    List<Customer> search(String word,String phone);
    List<Customer> selectByWord(String word);
    List<Customer> selectByPhone(String phone);

}
