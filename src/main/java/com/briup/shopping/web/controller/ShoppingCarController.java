package com.briup.shopping.web.controller;

import com.briup.shopping.bean.GO;
import com.briup.shopping.bean.Shoppingcar;
import com.briup.shopping.bean.ex.ShoppingCarEXzp;
import com.briup.shopping.service.IShoppingCarServicezp;
import com.briup.shopping.util.Message;
import com.briup.shopping.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppingcar")
@Api(description = "购物车管理")
public class ShoppingCarController {
    @Autowired
    private IShoppingCarServicezp iShoppingCarServicezp;
    @PostMapping("/saveOrUpdate")
    @ApiOperation(value = "购物车的添加和修改")
    public Message saveOrUpdate(Shoppingcar shoppingcar){
        iShoppingCarServicezp.saveOrUpdate(shoppingcar);
        return MessageUtil.success(shoppingcar);
    }
    @GetMapping("/deleteById")
    @ApiOperation(value = "根据ID删除某一个购物车")
    public Message deleteById(int id){
        iShoppingCarServicezp.deleteById(id);
        return MessageUtil.success();
    }
    @GetMapping("deleteAll")
    @ApiOperation(value="批量删除购物车")
    public Message deletaAll(int[] ids){
        for(int id:ids){
            iShoppingCarServicezp.deleteById(id);

        }
        return MessageUtil.success();
    }
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有购物车")
    public Message findAll(){
        List<ShoppingCarEXzp> list=iShoppingCarServicezp.findAll();
        return MessageUtil.success(list);
    }
    @GetMapping("/findById")
    @ApiOperation(value = "根据id查找某个购物车")
    public Message findById(int id){
        ShoppingCarEXzp shoppingCarEXzp=iShoppingCarServicezp.findById(id);
        return MessageUtil.success(shoppingCarEXzp);

    }
    @PostMapping("/insert")
    @ApiOperation(value = "往购物车中添加商品")
    public Message insert(int gid,int sid){
        iShoppingCarServicezp.saveOrUpdate(gid,sid);
        return MessageUtil.success();
    }
    @GetMapping("/deleteorderItem")
    @ApiOperation(value = "删除购物车中的某一个订单项")
    public Message deleteorderItem(int sid,int oid){
        iShoppingCarServicezp.deletego(sid,oid);
        return MessageUtil.success();
    }




}
