package com.briup.shopping.web.controller;

import com.briup.shopping.bean.Shoppingcar;
import com.briup.shopping.service.IShoppingCarServicezp;
import com.briup.shopping.util.Message;
import com.briup.shopping.util.MessageUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingcar")
@Api(description = "购物车管理")
public class ShoppingCarController {
    @Autowired
    private IShoppingCarServicezp iShoppingCarServicezp;
    @PostMapping
    public Message saveOrUpdate(Shoppingcar shoppingcar){
        iShoppingCarServicezp.saveOrUpdate(shoppingcar);
        return MessageUtil.success();
    }
}
