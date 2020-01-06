、package com.briup.shopping.web.controller;


import com.briup.shopping.bean.ex.SendGoodsEX;
import com.briup.shopping.service.ISendGoodsService;
import com.briup.shopping.util.Message;
import com.briup.shopping.util.MessageUtil;
import com.sun.deploy.net.URLEncoder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@Api(description = "待发货操作")
@RequestMapping("/SendGoods")
public class SendGoodsController {

    @Autowired
    private ISendGoodsService iSendGoodsService;
    @GetMapping("/findSendGoods")
    @ApiOperation(value = "查询待发货订单并下载订单")
    public void findSendGoodsDownload(String status,HttpServletResponse response) throws Exception {
        SendGoodsEX sendGoods =iSendGoodsService.findSendGoods(status);

        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet();
        //表头数据
        XSSFRow row=sheet.createRow(0);
        XSSFCell cell=row.createCell(0);
        cell.setCellType(CellType.STRING);
        cell.setCellValue(sendGoods.getId());
        //第二行
        XSSFRow row2=sheet.createRow(1);
        row2.createCell(0).setCellValue("商品名称");
        row2.createCell(1).setCellValue(sendGoods.getGoodsName());
        row2.createCell(0).setCellValue("用户名称");
        row2.createCell(1).setCellValue(sendGoods.getUserName());
        row2.createCell(0).setCellValue("订单总价");
        row2.createCell(1).setCellValue(sendGoods.getTotalPrice());
        row2.createCell(0).setCellValue("用户联系电话");
        row2.createCell(1).setCellValue(sendGoods.getPhone());
        row2.createCell(0).setCellValue("用户地址");
        row2.createCell(1).setCellValue(sendGoods.getAddress());
        row2.createCell(0).setCellValue("派送方式");
        row2.createCell(1).setCellValue(sendGoods.getExpressMethod());
        row2.createCell(0).setCellValue("日期");
        row2.createCell(1).setCellValue(sendGoods.getDate());

        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(sendGoods.getId()+"订单.xlsx", "utf-8"));

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
