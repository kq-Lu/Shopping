package com.briup.shopping.web.controller;


import com.briup.shopping.bean.ex.SendGoodsEX;
import com.briup.shopping.service.ISendGoodsService;
import com.briup.shopping.util.Message;
import com.briup.shopping.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(description = "待发货操作")
@RequestMapping("/SendGoods")
public class SendGoodsController {

    @Autowired
    private ISendGoodsService iSendGoodsService;
    @GetMapping("/findSendGoods")
    @ApiImplicitParam(name = "status",value = "状态",paramType = "query",dataType = "String",required = true)
    public Message findSendGoods(String status){
        List<SendGoodsEX> list =iSendGoodsService.findSendGoods(status);
        return MessageUtil.success(list);
    }
}
