package com.briup.shopping.web.controller;

import com.briup.shopping.bean.Goods;
import com.briup.shopping.bean.ex.GoodsEXl;
import com.briup.shopping.service.IGoodsEXlService;
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

@RequestMapping("/Goods")
@RestController
@Api(description = "商品信息")
public class GoodsController {
    @Autowired
    private IGoodsEXlService goodsEXlService;
    @PostMapping("/findAll")
    @ApiOperation(value = "查询所有商品信息")
    public Message findAll(){
        List<GoodsEXl> list=goodsEXlService.findAll();
        return MessageUtil.success(list);
    }
    @PostMapping("/findByWord")
    @ApiOperation(value = "模糊查询商品信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "word",value = "关键字",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "p1",value = "最低价格",paramType = "query",dataType = "int"),
            @ApiImplicitParam(name = "p2",value = "最高价格",paramType = "query",dataType = "int")})
    public Message findByWord(String word,Integer p1,Integer p2){
        List<GoodsEXl> list=goodsEXlService.findByWord(word,p1,p2);
        return MessageUtil.success(list);

    }
    @PostMapping("/addOrUpdate")
    @ApiOperation(value = "增加或修改商品信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "id",value = "商品编号",paramType = "query",dataType = "int"),
    @ApiImplicitParam(name = "name",value = "商品名",paramType = "query",dataType = "String"),
    @ApiImplicitParam(name = "price",value = "价格",paramType = "query",dataType = "int"),
    @ApiImplicitParam(name = "storage",value = "库存",paramType = "query",dataType = "int"),
    @ApiImplicitParam(name = "description",value = "描述",paramType = "query",dataType = "String"),
    @ApiImplicitParam(name = "categoryId",value = "商品类别栏目ID",paramType = "query",dataType = "int",required = true)})
    public Message saveOrUpdate(Goods goods){
        goodsEXlService.saveOrUpdate(goods);
        return MessageUtil.success("保存成功");
    }
    @GetMapping("/deleteById")
    @ApiOperation(value = "根据商品的ID删除商品")
    public Message deleteById(int id){
        goodsEXlService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
    @GetMapping("/deleteAll")
    @ApiOperation(value ="批量删除商品信息" )
    public Message deleteAll(int[] ids){
        for (int id:ids){

            goodsEXlService.deleteById(id);
        }
        return MessageUtil.success("删除成功");
    }
}
