package com.briup.shopping.web.controller;


import com.briup.shopping.bean.ex.ForPaymentEX;
import com.briup.shopping.service.IForPaymentService;
import com.briup.shopping.util.Message;
import com.briup.shopping.util.MessageUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "待支付操作")
@RequestMapping("/ForPayment")
public class ForPaymentController {

    @Autowired
    private IForPaymentService iForPaymentService;

    @GetMapping("/findForPayment")
    public Message findForPayment(String status){
        ForPaymentEX forPaymentEX=iForPaymentService.findForPayment(status);
        return MessageUtil.success(forPaymentEX);
    }

}
