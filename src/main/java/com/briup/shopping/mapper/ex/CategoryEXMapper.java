package com.briup.shopping.mapper.ex;

import com.briup.shopping.bean.ex.CategoryEXzp;

import java.util.List;

public interface CategoryEXMapper {
    List<CategoryEXzp> findAllcategory();

    CategoryEXzp findById(int id);

    List<CategoryEXzp> findByWord(String word);
}
