package com.briup.shopping.web.controller;

import com.briup.shopping.bean.Order;
import com.briup.shopping.bean.ex.OrderEXg;
import com.briup.shopping.service.IOrderServiceg;
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
@RequestMapping("/oredr")
@Api(description = "订单管理")
public class OderControllerg {
    @Autowired
    private IOrderServiceg orderService;
    @GetMapping("/findAllOrder")
    @ApiOperation(value = "查询所有订单")
    public Message selectAll(){

        List<OrderEXg> list=orderService.findAllOrder();
        return MessageUtil.success(list);
    }
    @GetMapping("/deleteById")
    @ApiOperation(value = "根据Id删除订单")
    @ApiImplicitParam(name = "id",value="根据Id删除",paramType = "query",dataType = "int",required = true)
    public Message deleteById(int id){
        orderService.deleteById(id);
        return MessageUtil.success();
    }
    @GetMapping("/deleteBatch")
    @ApiOperation(value = "批量删除")
    @ApiImplicitParam(name = "ids",value="根据Id删除多条",paramType = "query",dataType = "int",required = true)
    public Message deleteBatch(int []ids){
        for(int id:ids) {
            orderService.deleteById(id);
        }
        return MessageUtil.success();
    }
    @PostMapping("/saveOrder")
    @ApiOperation(value = "添加订单")
    @ApiImplicitParams({ @ApiImplicitParam(name = "totalprice",value="总价",paramType = "query",dataType = "int"),
            @ApiImplicitParam(name = "customerId",value="顾客Id",paramType = "query",dataType = "int"),
            @ApiImplicitParam(name = "paymentId",value="支付的Id，选择支付方式",paramType = "query",dataType = "int"),
            @ApiImplicitParam(name = "expressId",value="配送Id，选择配送方式",paramType = "query",dataType = "int"),
            @ApiImplicitParam(name = "statusId",value="状态Id",paramType = "query",dataType = "int")
    }

            )
    public Message saveOrder(Order order){
        orderService.saveOrupdate(order);
        return MessageUtil.success();
    }
    @PostMapping("/updateOrder")
    @ApiOperation(value = "更新订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value="根据Id修改信息",paramType = "query",dataType = "int",required = true),
            @ApiImplicitParam(name = "totalprice",value="总价",paramType = "query",dataType = "int"),
            @ApiImplicitParam(name = "customerId",value="顾客Id",paramType = "query",dataType = "int"),
            @ApiImplicitParam(name = "paymentId",value="支付的Id，选择支付方式",paramType = "query",dataType = "int"),
            @ApiImplicitParam(name = "expressId",value="配送Id，选择配送方式",paramType = "query",dataType = "int"),
            @ApiImplicitParam(name = "statusId",value="状态Id",paramType = "query",dataType = "int")
    }

    )
    public Message updateOrder(Order order){
        orderService.saveOrupdate(order);
        return MessageUtil.success();
    }
    @GetMapping("/selectById")
    @ApiOperation(value ="预览订单" )
    @ApiImplicitParam(name = "id",value="根据Id查询",paramType = "query",dataType = "int",required = true)
       public Message selectById(int id){

        OrderEXg order=orderService.selectById(id);
        return MessageUtil.success(order);
    }





}
