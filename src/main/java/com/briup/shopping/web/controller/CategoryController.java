package com.briup.shopping.web.controller;

import com.briup.shopping.bean.Category;
import com.briup.shopping.bean.ex.CategoryEXzp;
import com.briup.shopping.service.ICategoryServicezp;
import com.briup.shopping.util.Message;
import com.briup.shopping.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/category")
@RestController
@Api(description = "分类的管理")
public class CategoryController {
    @Autowired
    private ICategoryServicezp iCategoryServicezp;
    @PostMapping("/saveOrUpdate")
    @ApiOperation(value = "分类的增加和修改")
    public Message saveOrUpdate(Category category){
        iCategoryServicezp.saveOrUpdate(category);
        return MessageUtil.success();
    }
    @GetMapping("/deleteById")
    @ApiOperation(value = "分类的删除")
    public Message deleteById(int id){
        iCategoryServicezp.deleteById(id);
        return MessageUtil.success();
    }
    @GetMapping("/deleteAll")
    @ApiOperation(value = "删除所有分类")
    public Message deleteByAll(int[] ids){
        for(int id:ids){
            iCategoryServicezp.deleteById(id);
        }
        return MessageUtil.success();
    }
    @GetMapping("/findAll")
    @ApiOperation(value="查询所有分类")
    public Message findAll(){
        List<CategoryEXzp> list=iCategoryServicezp.findAll();
        return MessageUtil.success(list);
    }
}
