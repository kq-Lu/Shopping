package com.briup.shopping.service.impl;

import com.briup.shopping.bean.*;
import com.briup.shopping.bean.ex.OrderEXg;
import com.briup.shopping.mapper.GOMapper;
import com.briup.shopping.mapper.GoodsMapper;
import com.briup.shopping.mapper.OrderMapper;
import com.briup.shopping.mapper.ex.GoodsEXgMapper;
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
    @Autowired
    private GOMapper goMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsEXgMapper goodsEXgMapper;

    @Override
    public List<OrderEXg> findAllOrder() throws RuntimeException {
        totalPrice();
        List<OrderEXg> list = orderEXgMapper.findAll();

        return list;
    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public OrderEXg selectById(int id) throws RuntimeException {
        totalPrice();
        OrderEXg orderEXg = orderEXgMapper.selectById(id);
        return orderEXg;

    }

    @Override
    public void totalPrice() throws RuntimeException {

        int goodsId;
        int mount;
        Double tprice;
        GOExample goExample = new GOExample();
        List<GO> listgo = goMapper.selectByExample(goExample);

        for (GO go : listgo) {
            goodsId = go.getGoodsId();
            mount = go.getAmount();
            Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
            Double price = goods.getPrice();
            tprice = price * mount;
            orderEXgMapper.updateTotalprice(tprice, go.getOrderId());
        }

    }

    @Override
    public void creatOrder(Order order, int[] ids) throws RuntimeException {

        order.setDate(new Date());
        Random random = new Random();
        order.setCode(random.nextInt(9000) + 10000);
        orderMapper.insert(order);

        for (int i = 0; i < ids.length; i++) {
            GO go = new GO();
            go.setAmount(2);
            go.setGoodsId(ids[i]);
            go.setOrderId(order.getId());
            goMapper.insert(go);

        }

    }


    @Override
    public void updateOrder(Order order) throws RuntimeException {
        if (order == null) {
            throw new RuntimeException("参数不能为空");
        } else {
            order.setDate(new Date());
            Random random = new Random();
            order.setCode(random.nextInt(9000) + 10000);
            orderMapper.updateByPrimaryKey(order);
        }
    }

    @Override
    public void updateStore(int id) throws RuntimeException {
        int samout;
        int Tstore;
        int Astore;
        int goodsId;

                GOExample goExample = new GOExample();
                goExample.createCriteria().andOrderIdEqualTo(id);
                System.out.println(id);
                List<GO> listgo = goMapper.selectByExample(goExample);
                for (GO go : listgo) {

                    samout = go.getAmount();

                    Goods goods1= goodsMapper.selectByPrimaryKey(go.getGoodsId());
                    // Goods goods1=goExample.createCriteria().andGoodsIdEqualTo(go.getId());


                    Tstore = goods1.getStorage();

                    Astore = Tstore - samout;
                    goodsId = go.getGoodsId();
                    goodsEXgMapper.updateStore(Astore, goodsId);
                }

            }




}
