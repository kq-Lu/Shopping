package com.briup.shopping.web.controller;

import com.briup.shopping.bean.ex.ForReceiveEX;
import com.briup.shopping.service.IForReceiveService;
import com.briup.shopping.util.Message;
import com.briup.shopping.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(description = "待收货操作")
@RequestMapping("/ForReceive")
public class ForReceiveController {
    @Autowired
    private IForReceiveService iForReceiveService;
    @GetMapping("/findForReceive")
    @ApiOperation(value = "待收货")
    @ApiImplicitParam(name = "status",value = "状态",paramType = "query",dataType = "String",required = true)
    public Message findForReceive(String status){
        List<ForReceiveEX> list=iForReceiveService.findForReceive(status);
        return MessageUtil.success(list);
    }
}
