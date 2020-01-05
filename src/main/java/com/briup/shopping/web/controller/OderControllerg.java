package com.briup.shopping.web.controller;

import com.briup.shopping.bean.Order;
import com.briup.shopping.bean.ex.OrderEXg;
import com.briup.shopping.service.IOrderServiceg;
import com.briup.shopping.util.Message;
import com.briup.shopping.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/oredr")
public class OderControllerg {
    @Autowired
    private IOrderServiceg orderService;
    @GetMapping("/findAllOrder")
    public Message selectAll(){
        List<OrderEXg> list=orderService.findAllOrder();
        return MessageUtil.success(list);
    }
    @GetMapping("/deleteById")
    public Message deleteById(int id){
        orderService.deleteById(id);
        return MessageUtil.success();
    }
    @GetMapping("/deleteBatch")
    public Message deleteBatch(int []ids){
        for(int id:ids) {
            orderService.deleteById(id);
        }
        return MessageUtil.success();
    }
    @PostMapping("/saveOrder")
    public Message saveOrder(Order order){
        orderService.saveOrupdate(order);
        return MessageUtil.success();
    }
    @PostMapping("/updateOrder")
    public Message updateOrder(Order order){
        orderService.saveOrupdate(order);
        return MessageUtil.success();
    }
    @GetMapping("/selectById")
       public Message selectById(int id){
        OrderEXg order=orderService.selectById(id);
        return MessageUtil.success(order);
    }





}
