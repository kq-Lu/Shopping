package com.briup.shopping.service.impl;

import com.briup.shopping.bean.Comment;
import com.briup.shopping.bean.ex.CommentEXg;
import com.briup.shopping.mapper.CommentMapper;
import com.briup.shopping.mapper.ex.CommentEXgMapper;
import com.briup.shopping.service.ICommentServiceg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CommentServiceImplg implements ICommentServiceg {
    @Autowired
    private CommentEXgMapper commentEXgMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<CommentEXg> findAll() throws RuntimeException {
        List<CommentEXg> list=commentEXgMapper.findAll();

        return list;
    }

    @Override
    public void saveComment(Comment comment) throws RuntimeException {
        comment.setDate(new Date());
        if(comment==null){
            throw new RuntimeException("参数为空");
        }
        else if(comment.getId()==null){

            commentMapper.insert(comment);
        }

    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateComment(Comment comment) throws RuntimeException {
        comment.setDate(new Date());
        Comment comment1=commentMapper.selectByPrimaryKey(comment.getId());
        comment.setGoId(comment1.getGoId());
        commentMapper.updateByPrimaryKey(comment);
    }

}
