package com.briup.shopping.web.controller;

import com.briup.shopping.bean.ex.ShoppingCarEXzp;
import com.briup.shopping.service.IShoppingCarServicezp;
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

@RestController
@RequestMapping("/shoppingcar")
@Api(description = "购物车的管理")
public class ShoppingCarController {
    @Autowired
    private IShoppingCarServicezp iShoppingCarServicezp;
    @PostMapping("/saveOrUpdate")
    @ApiOperation(value="购物车的添加和更新")
    public Message saveOrUpdate(Shoppingcar shoppingcar){
        iShoppingCarServicezp.saveOrUpdate(shoppingcar);
        return MessageUtil.success();
    }
    @GetMapping("/deleteById")
    @ApiOperation(value="根据id删除购物车里的东西" )
    public Message deleteById(int id){
        iShoppingCarServicezp.deleteById(id);
        return MessageUtil.success();
    }
    @GetMapping("/deleteAll")
    @ApiOperation(value="批量删除购物车里的商品")
    public Message deleteAll(int[] ids){
        for(int id: ids ){
            iShoppingCarServicezp.deleteById(id);
        }
        return MessageUtil.success();
    }
    @GetMapping("/findAllShopping")
    @ApiOperation(value="查询购物车中的所有商品")
    public Message findAllShopping(){
        List<ShoppingCarEXzp>list= iShoppingCarServicezp.findAll();
        return MessageUtil.success(list);
    }

    @GetMapping("/selectById")
    @ApiOperation(value="根据id查询购物车")
    public Message selectById(int id){
        ShoppingCarEXzp shoppingCarEXzp = iShoppingCarServicezp.selectById(id);
        return MessageUtil.success(shoppingCarEXzp);
    }
}
