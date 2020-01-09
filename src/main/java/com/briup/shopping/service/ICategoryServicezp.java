package com.briup.shopping.service;

import com.briup.shopping.bean.Category;
import com.briup.shopping.bean.ex.CategoryEXzp;

import java.util.List;

public interface ICategoryServicezp {
    void saveOrUpdate(Category category) throws RuntimeException;
    void deleteById(int id) throws RuntimeException;
    List<CategoryEXzp> findAll() throws RuntimeException;
    CategoryEXzp findById(int id) throws RuntimeException;
    List<CategoryEXzp> findByWord(String word) throws RuntimeException;
}
