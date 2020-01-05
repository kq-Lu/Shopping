package com.briup.shopping.service.impl;

import com.briup.shopping.bean.Order;
import com.briup.shopping.bean.ex.OrderEXg;
import com.briup.shopping.mapper.OrderMapper;
import com.briup.shopping.mapper.ex.OrderEXgMapper;
import com.briup.shopping.service.IOrderServiceg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class OrderServicegImplg implements IOrderServiceg {
    @Autowired
    private OrderEXgMapper orderEXgMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<OrderEXg> findAllOrder() throws RuntimeException {
        List<OrderEXg> list= orderEXgMapper.findAll();
        return list;
    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveOrupdate(Order order) throws RuntimeException {
        if(order==null){
            throw new RuntimeException("参数不能为空");
        }
        if(order.getId()==null){
            order.setDate(new Date());
            Random random = new Random();
            order.setCode(random.nextInt(9000)+10000);
            orderMapper.insert(order);
        }
        else {
            orderMapper.updateByPrimaryKey(order);
        }

    }

    @Override
    public OrderEXg selectById(int id) throws RuntimeException {
       OrderEXg orderEXg = orderEXgMapper.selectById(id);
       return orderEXg;

    }

}
