package com.briup.shopping.web.controller;

import com.briup.shopping.bean.Collect;
import com.briup.shopping.bean.ex.CollectEXzp;
import com.briup.shopping.service.ICollectServicezp;
import com.briup.shopping.util.Message;
import com.briup.shopping.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/collect")
@Api(description = "收藏管理")
public class CollectController {
    @Autowired
    private ICollectServicezp iCollectServicezp;
    @PostMapping("/insert")
    @ApiOperation(value="添加收藏信息")
    public Message saveOrUpdate(int gid,int sid){
        iCollectServicezp.insert(gid, sid);
        return MessageUtil.success();
    }
    @GetMapping("/deleteById")
    @ApiOperation(value = "根据id删除收藏信息")
    public Message deleteById(int id){
        iCollectServicezp.deleteById(id);
        return MessageUtil.success();
    }
    @GetMapping("deleteAll")
    @ApiOperation(value ="批量删除收藏信息")
    public Message deleteAll(int[] ids){
        for(int id:ids){
            iCollectServicezp.deleteById(id);
        }
        return MessageUtil.success();
    }
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有的收藏信息")
    public Message findAll(){
        List<CollectEXzp> list=iCollectServicezp.findAll();
        return MessageUtil.success(list);
    }
    @GetMapping("/findByword")
    @ApiOperation(value = "根据关键字查询")
    public Message findByword(String word){
        List<CollectEXzp> list=iCollectServicezp.findByWord(word);
        return MessageUtil.success(list);
    }

}
