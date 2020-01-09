package com.briup.shopping.service.impl;

import com.briup.shopping.bean.Category;
import com.briup.shopping.bean.ex.CategoryEXzp;
import com.briup.shopping.mapper.CategoryMapper;
import com.briup.shopping.mapper.CollectMapper;
import com.briup.shopping.mapper.ex.CategoryEXMapper;
import com.briup.shopping.service.ICategoryServicezp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryServicezp {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CategoryEXMapper categoryEXMapper;

    @Override
    public void saveOrUpdate(Category category) throws RuntimeException {
        if (category == null) {
            throw new RuntimeException("参数为空");
        }
        if (category.getId() == null) {
            categoryMapper.insert(category);
        } else {
            categoryMapper.updateByPrimaryKey(category);
        }
    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CategoryEXzp> findAll() throws RuntimeException {
        List<CategoryEXzp> list = categoryEXMapper.findAllcategory();
        return list;

    }

    @Override
    public CategoryEXzp findById(int id) throws RuntimeException {
        CategoryEXzp categoryEXzp = categoryEXMapper.findById(id);
        return categoryEXzp;
    }

    @Override
    public List<CategoryEXzp> findByWord(String word) throws RuntimeException {
        word = word == null ? "" : word;
        if (word == null || "".equals(word)) {
            return categoryEXMapper.findAllcategory();
        } else {
            word = "%" + word + "%";
            return categoryEXMapper.findByWord(word);
        }
    }
}