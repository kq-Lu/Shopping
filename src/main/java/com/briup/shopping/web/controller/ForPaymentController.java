package com.briup.shopping.web.controller;


import com.briup.shopping.bean.ex.ForPaymentEX;
import com.briup.shopping.service.IForPaymentService;
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
@Api(description = "待支付操作")
@RequestMapping("/ForPayment")
public class ForPaymentController {

    @Autowired
    private IForPaymentService iForPaymentService;

    @GetMapping("/findForPayment")
    @ApiOperation(value = "查询所有待支付订单")
    @ApiImplicitParam(name = "status",value = "状态",paramType = "query",dataType = "String",required = true)
    public Message findForPayment(String status){
        List<ForPaymentEX> list=iForPaymentService.findForPayment(status);
        return MessageUtil.success(list);
    }

    @GetMapping("/deleteForPayment")
    @ApiOperation(value = "删除未支付的订单")
    @ApiImplicitParam(name = "id",value = "订单id",paramType = "query",dataType = "int",required = true)
    public Message deleteForPayment(int id){
        iForPaymentService.deleteOrderGO(id);
        return MessageUtil.success("删除成功");
    }

    @GetMapping("/deleteMore")
    @ApiOperation(value = "批量删除未支付订单")
    @ApiImplicitParam(name = "ids",value = "根据多个id删除未支付订单",paramType = "query",dataType = "int",required = true,allowMultiple = true)
    public Message deleteMore(int[] ids){
        iForPaymentService.deleteMore(ids);
        return MessageUtil.success("删除成功");
    }

    @PostMapping("/GoPayment")
    @ApiOperation(value = "去付款")
    @ApiImplicitParam(name = "id",value = "订单id",paramType = "query",dataType = "int",required = true)
    public Message GoPayment(int id){
        iForPaymentService.GoPayment(id);
        return MessageUtil.success("成功");
    }
}
