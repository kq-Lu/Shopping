package com.briup.shopping.web.controller;

import com.briup.shopping.bean.Goods;
import com.briup.shopping.service.IHotgoodsServiceg;
import com.briup.shopping.util.Message;
import com.briup.shopping.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/HotGoods")
@Api(description = "热销商品推荐")
public class HotGoodsController {
    @Autowired
    private IHotgoodsServiceg hotgoodsServiceg;
    @GetMapping("/selectAll")
    @ApiOperation(value = "查询所有的热销商品")
    public Message selectAll(){
        List<Goods> goodsList =  hotgoodsServiceg.selectAll();
        return MessageUtil.success(goodsList);
    }
}
