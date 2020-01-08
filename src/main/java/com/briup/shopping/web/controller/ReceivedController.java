package com.briup.shopping.web.controller;

import com.briup.shopping.bean.Comment;
import com.briup.shopping.bean.ex.ReceivedEX;
import com.briup.shopping.service.IReceivedService;
import com.briup.shopping.util.Message;
import com.briup.shopping.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@Api(description = "已收货操作")
@RequestMapping("/Received")
public class ReceivedController {

    @Autowired
    private IReceivedService iReceivedService;
    @GetMapping("/findReceived")
    @ApiOperation(value = "查询已收货")
    @ApiImplicitParam(name="status",value = "状态",paramType = "query",dataType = "String",required = true)
    public Message findReceived(String status){
        List<ReceivedEX> list=iReceivedService.findReceived(status);
        return MessageUtil.success(list);
    }


    @GetMapping("/deleteReceived")
    @ApiOperation(value = "删除已收货的订单")
    @ApiImplicitParam(name = "id",value = "订单id",paramType = "query",dataType = "int",required = true)
    public Message deleteReceived(int id){
        iReceivedService.deleteReceivedGOComment(id);
        return MessageUtil.success("删除成功");
    }

    @GetMapping("/deleteMoreReceivedGOComment")
    @ApiOperation(value = "删除多条已收货的订单")
    @ApiImplicitParam(name = "ids",value = "多个已收货订单号",paramType = "query",dataType = "int",required = true,allowMultiple = true)
    public Message deleteMoreReceivedGOComment(int[] ids){
        iReceivedService.deleteMoreReceivedGOComment(ids);
        return MessageUtil.success("删除成功");
    }



    @PostMapping("/insertDescription")
    @ApiOperation(value = "写评论")
    public Message insertDescription(Comment comment){
        iReceivedService.insertDescription(comment);
        return MessageUtil.success("评论成功");
    }


    @GetMapping("/deleteDescription")
    @ApiOperation(value = "删除不好的评论")
    @ApiImplicitParam(name = "id",value = "评论id",paramType = "query",dataType = "int",required = true)
    public Message deleteDescription(int id){
        iReceivedService.deleteDescription(id);
        return MessageUtil.success("删除成功");
    }


//    @InitBinder
//    public void initBinder(WebDataBinder binder, WebRequest request) {
//        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
//        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
//    }
}
