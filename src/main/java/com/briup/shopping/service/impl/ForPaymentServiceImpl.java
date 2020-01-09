package com.briup.shopping.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.briup.shopping.bean.*;
import com.briup.shopping.bean.ex.ForPaymentEX;
import com.briup.shopping.bean.ex.OrderEXg;
import com.briup.shopping.mapper.GOMapper;
import com.briup.shopping.mapper.GoodsMapper;
import com.briup.shopping.mapper.OrderMapper;
import com.briup.shopping.mapper.ex.ForPaymentEXMapper;
import com.briup.shopping.service.IForPaymentService;
import com.briup.shopping.service.IOrderServiceg;
import com.briup.shopping.util.AlipayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class ForPaymentServiceImpl implements IForPaymentService {

    @Autowired
    private IOrderServiceg orderServiceg;
    @Autowired
    private GOMapper goMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private IForPaymentService iForPaymentService;
    @Autowired
    private ForPaymentEXMapper forPaymentEXMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<ForPaymentEX> findForPayment(String status) throws RuntimeException {

        if ("待支付".equals(status)){
            return forPaymentEXMapper.findForPayment(3);

        }
        return null;
    }

//删除未支付的订单和关联表a_go
    @Override
    public void deleteOrderGO(int id) throws RuntimeException {
        forPaymentEXMapper.deleteOrder(id);
        forPaymentEXMapper.deleteGO(id);
    }

    @Override
    public void deleteMore(int[] ids) throws RuntimeException {
        for(int i=0;i<ids.length;i++){
            forPaymentEXMapper.deleteOrder(ids[i]);
            forPaymentEXMapper.deleteGO(ids[i]);
        }
    }

    @Override
    public void GoPayment(HttpServletResponse response, HttpServletRequest request, int id) throws RuntimeException {
        OrderEXg order = orderServiceg.selectById(id);

        try {
            AlipayClient alipayClient =
                    AlipayConfig.getAlipayClient();
            //设置请求参数
            AlipayTradePagePayRequest alipayRequest =
                    new AlipayTradePagePayRequest();

            AlipayTradePayModel model =
                    new AlipayTradePayModel();

            // 设定订单号 必须要写,且订单号不能重复，目前已经只是做测试，已经写死
            model.setOutTradeNo(order.getCode()+"");

            // 设置订单金额
            model.setTotalAmount(order.getTprice()+"");
            // 订单名字

            String subject  = new String();
            String description = new String();
            GOExample example = new GOExample();
            example.createCriteria().andOrderIdEqualTo(id);
            List<GO> gos = goMapper.selectByExample(example);
            for(GO go:gos){
                Goods goods = goodsMapper.selectByPrimaryKey(go.getGoodsId());
                subject = goods.getName();
                description = goods.getDescription();
            }

            model.setSubject(subject);
            // 订单描述
//            model.setBody(System.currentTimeMillis()+"");
            model.setBody(description);

            // 产品码
            model.setProductCode("FAST_INSTANT_TRADE_PAY");

            // 设置参数
            alipayRequest.setBizModel(model);

            // 设置回调地址
            alipayRequest.setReturnUrl(AlipayConfig.return_url);

            String result = alipayClient.pageExecute(alipayRequest).getBody();

            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println(result);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String Callback(HttpServletResponse response, HttpServletRequest request) throws RuntimeException, IOException, AlipayApiException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

        //——请在这里编写您的程序（以下代码仅作参考）——
        if(signVerified) {

            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            OrderExample example = new OrderExample();
            example.createCriteria().andCodeEqualTo(Integer.parseInt(out_trade_no));
            List<Order> orders = orderMapper.selectByExample(example);
            for(Order order:orders){
                forPaymentEXMapper.goPayment(order.getId());
            }

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");

//            out.println("trade_no:"+trade_no+"\n");
//            out.println("out_trade_no:"+out_trade_no);
//            out.println("total_amount:"+total_amount);
//            out.println("已付款");


        }else {
            out.println("验签失败");
        }

        return null;
    }
}
