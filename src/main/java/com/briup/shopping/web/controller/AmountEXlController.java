package com.briup.shopping.web.controller;

import com.briup.shopping.bean.ex.AmountEXl;
import com.briup.shopping.service.IAmountEXlService;
import com.briup.shopping.util.Message;
import com.briup.shopping.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/amount")
@RestController
@Api(description = "统计各状态订单的商品销售数量")
public class AmountEXlController {
    @Autowired
    private IAmountEXlService amountEXlService;
    @PostMapping("/count")
    @ApiOperation(value = "统计各状态订单下的商品销售数量")
    public Message findAll(){
        List<AmountEXl> list=amountEXlService.findAll();
        return MessageUtil.success(list);
    }


}
