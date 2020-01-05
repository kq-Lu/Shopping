package com.briup.shopping.service;

import com.briup.shopping.bean.Customer;

import java.util.List;

public interface ICustomerlService {
    List<Customer> findAll() throws RuntimeException;
    List<Customer> search(String word,String phone) throws RuntimeException;
    void saveOrUpdate(Customer customer) throws RuntimeException;
    void deleteById(int id) throws RuntimeException;
    List<Customer> findByAddress(String key) throws RuntimeException;
}
