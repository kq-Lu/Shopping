package com.briup.shopping.service;

import com.briup.shopping.bean.ex.CommentEXg;

import java.util.List;

public interface ICommentServiceg {
    List<CommentEXg> findAll() throws RuntimeException;
    void saveOrupdate(Comment comment) throws RuntimeException;
    void deleteById(int id) throws RuntimeException;
}
