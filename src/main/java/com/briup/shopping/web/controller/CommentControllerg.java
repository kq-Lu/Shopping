package com.briup.shopping.web.controller;

import com.briup.shopping.bean.Comment;
import com.briup.shopping.bean.ex.CommentEXg;
import com.briup.shopping.service.ICommentServiceg;
import com.briup.shopping.util.Message;
import com.briup.shopping.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentControllerg {
    @Autowired
    private ICommentServiceg commentServiceg;
    @GetMapping("/selectAll")
    public Message selectAll(){
        List<CommentEXg> list=commentServiceg.findAll();

        return MessageUtil.success(list);
    }
    @PostMapping("/saveComment")
    public Message saveComment(Comment comment){
        commentServiceg.saveOrupdate(comment);
        return MessageUtil.success();
    }
    @PostMapping("/updateComment")
    public Message updateComment(Comment comment){
        commentServiceg.saveOrupdate(comment);
        return MessageUtil.success();
    }
   @GetMapping("/deleteById")
        public Message deleteById(int id){
        commentServiceg.deleteById(id);
        return MessageUtil.success();
        }
    @GetMapping("/delteBatch")
    public Message deleteBatch(int[]ids){
        for(int id:ids){
            commentServiceg.deleteById(id);
        }
        return MessageUtil.success();
    }
}




