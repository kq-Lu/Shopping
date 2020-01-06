package com.briup.shopping.web.controller;


import com.briup.shopping.bean.ex.SendGoodsEX;
import com.briup.shopping.service.ISendGoodsService;
import com.briup.shopping.util.Message;
import com.briup.shopping.util.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@Api(description = "待发货操作")
@RequestMapping("/SendGoods")
public class SendGoodsController {

    @Autowired
    private ISendGoodsService iSendGoodsService;
    @GetMapping("/findSendGoods")
    @ApiOperation(value = "查询待发货订单")
    public Message findSendGoods(String status) {
        List<SendGoodsEX> list =iSendGoodsService.findSendGoods(status);
        return MessageUtil.success(list);
    }

    @GetMapping("/download")
    @ApiOperation(value = "下载订单")
    public void download(int id,HttpServletResponse response) throws Exception {

        SendGoodsEX sendGoodsEX=iSendGoodsService.download(id);

        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet();
        //表头数据
        XSSFRow row=sheet.createRow(0);
        //XSSFCell cell=row.createCell(0);
        //cell.setCellType(CellType.STRING);
        row.createCell(0).setCellValue("订单编号");
        row.createCell(1).setCellValue(sendGoodsEX.getId());
        //第二行
        XSSFRow row2=sheet.createRow(1);
        XSSFRow row3=sheet.createRow(2);
        row2.createCell(0).setCellValue("商品名称");
        row3.createCell(0).setCellValue(sendGoodsEX.getGoodsName());
        row2.createCell(1).setCellValue("用户名称");
        row3.createCell(1).setCellValue(sendGoodsEX.getUserName());
        row2.createCell(2).setCellValue("订单总价");
        row3.createCell(2).setCellValue(sendGoodsEX.getTotalPrice());
        row2.createCell(3).setCellValue("用户联系电话");
        row3.createCell(3).setCellValue(sendGoodsEX.getPhone());
        row2.createCell(4).setCellValue("用户地址");
        row3.createCell(4).setCellValue(sendGoodsEX.getAddress());
        row2.createCell(5).setCellValue("派送方式");
        row3.createCell(5).setCellValue(sendGoodsEX.getExpressMethod());
        row2.createCell(6).setCellValue("日期");
        row3.createCell(6).setCellValue(sendGoodsEX.getDate());

        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(sendGoodsEX.getId()+"订单.xlsx", "utf-8"));
        workbook.write(response.getOutputStream());
    }

    @PostMapping("/SendOut")
    @ApiOperation(value = "发货")
    @ApiImplicitParam(name = "id",value = "发货订单id",paramType = "query",dataType = "id",required = true)
    public Message SendOut(int id){
        iSendGoodsService.SendOut(id);
        return MessageUtil.success("发货成功");
    }

}
