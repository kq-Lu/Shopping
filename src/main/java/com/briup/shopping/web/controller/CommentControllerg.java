package com.briup.shopping.web.controller;

import com.briup.shopping.bean.ex.CommentEXg;
import com.briup.shopping.service.ICommentServiceg;
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
@RequestMapping("/comment")
@Api(description = "留言管理")
public class CommentControllerg {
    @Autowired
    private ICommentServiceg commentServiceg;
    @GetMapping("/selectAll")
    @ApiOperation(value = "查询所有评论")
    public Message selectAll(){
        List<CommentEXg> list=commentServiceg.findAll();

        return MessageUtil.success(list);
    }
    @PostMapping("/saveComment")
    @ApiOperation(value = "添加pinglun")
    @ApiImplicitParams({ @ApiImplicitParam(name = "description",value="评论",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "orderId",value="订单Id",paramType = "query",dataType = "int")
    })
    public Message saveComment(Comment comment){
        commentServiceg.saveOrupdate(comment);
        return MessageUtil.success();
    }
    @PostMapping("/updateComment")
    @ApiOperation(value = "修改评论")
    @ApiImplicitParams({ @ApiImplicitParam(name = "id",value="根据Id修改评论",paramType = "query",dataType = "int",required = true),
            @ApiImplicitParam(name = "description",value="评论",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "orderId",value="订单Id",paramType = "query",dataType = "int")
    })
    public Message updateComment(Comment comment){
        commentServiceg.saveOrupdate(comment);
        return MessageUtil.success();
    }
   @GetMapping("/deleteById")
   @ApiOperation(value = "根据Id删除评论")
   @ApiImplicitParam(name = "id",value="根据Id删除",paramType = "query",dataType = "int",required = true)
        public Message deleteById(int id){
        commentServiceg.deleteById(id);
        return MessageUtil.success();
        }
    @GetMapping("/delteBatch")
    @ApiOperation(value = "批量删除")
    @ApiImplicitParam(name = "ids",value="根据Id删除多条",paramType = "query",dataType = "int",required = true)
    public Message deleteBatch(int[]ids){
        for(int id:ids){
            commentServiceg.deleteById(id);
        }
        return MessageUtil.success();
    }
}




