package com.briup.shopping.web.controller;

import com.briup.shopping.bean.Customer;
import com.briup.shopping.service.ICustomerlService;

import com.briup.shopping.util.Message;
import com.briup.shopping.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customerl")
@Api(description = "顾客信息")
public class CustomerlController {
    @Autowired
    private ICustomerlService customerlService;
    @PostMapping("/findAll")
    @ApiOperation(value = "查询顾客信息")
    public Message findAll(){
        List<Customer> list=customerlService.findAll();
        return MessageUtil.success(list);
    }
    @PostMapping("/searchByWord")
    @ApiOperation(value = "模糊查询顾客信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "word",value = "关键字",paramType = "query",dataType = "String"),
    @ApiImplicitParam(name = "phone",value = "电话号码后四位",paramType = "query",dataType = "String")})
    public Message search(String word,String phone){
        List<Customer> list=customerlService.search(word, phone);
        return MessageUtil.success(list);
    }
    @PostMapping("/saveOrUpdate")
    @ApiOperation(value = "添加或更新顾客信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "id",value = "顾客ID",paramType = "query",dataType = "int"),
    @ApiImplicitParam(name = "username",value = "顾客账号",paramType = "query",dataType = "String"),
    @ApiImplicitParam(name = "password",value = "密码",paramType = "query",dataType = "String"),
    @ApiImplicitParam(name = "phone",value = "电话号码",paramType = "query",dataType = "int"),
    @ApiImplicitParam(name = "address",value = "顾客地址",paramType = "query",dataType = "String")})
    public Message saveOrUpdate(Customer customer){
        customerlService.saveOrUpdate(customer);
        return MessageUtil.success("更新成功");
    }
    @GetMapping("/deleteById")
    @ApiOperation(value = "根据顾客ID删除信息")
    public Message deleteById(int id){
        customerlService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
    @GetMapping("/delete")
    @ApiOperation(value ="批量删除顾客信息")
    public Message delete(int[] ids){
        for (int id:ids){
            customerlService.deleteById(id);
        }
        return MessageUtil.success("删除成功");
    }
    @PostMapping("/count")
    @ApiOperation(value = "统计区域顾客人数")
    @ApiImplicitParam(name = "key",value = "请填入省份的名字",paramType = "query",dataType = "String")
    public Message count(String key){
       List<Customer> list=customerlService.findByAddress(key);

        return MessageUtil.success(key+"省的顾客人数为："+list.size());
    }
}




