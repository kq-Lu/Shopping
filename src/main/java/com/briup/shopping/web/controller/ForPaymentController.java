package com.briup.shopping.web.controller;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.briup.shopping.bean.GO;
import com.briup.shopping.bean.GOExample;
import com.briup.shopping.bean.Goods;
import com.briup.shopping.bean.ex.ForPaymentEX;
import com.briup.shopping.bean.ex.OrderEXg;
import com.briup.shopping.mapper.GOMapper;
import com.briup.shopping.mapper.GoodsMapper;
import com.briup.shopping.service.IForPaymentService;
import com.briup.shopping.service.IOrderServiceg;
import com.briup.shopping.util.AlipayConfig;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@Api(description = "待支付操作")
@RequestMapping("/ForPayment")
public class ForPaymentController {
    @Autowired
    private IOrderServiceg orderServiceg;
    @Autowired
    private GOMapper goMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private IForPaymentService iForPaymentService;

    @GetMapping("/findForPayment")
    @ApiOperation(value = "查询所有待支付订单")
    @ApiImplicitParam(name = "status",value = "状态",paramType = "query",dataType = "String",required = true)
    public Message findForPayment(String status){
        List<ForPaymentEX> list=iForPaymentService.findForPayment(status);
        return MessageUtil.success(list);
    }

    @GetMapping("/deleteForPayment")
    @ApiOperation(value = "删除未支付的订单")
    @ApiImplicitParam(name = "id",value = "订单id",paramType = "query",dataType = "int",required = true)
    public Message deleteForPayment(int id){
        iForPaymentService.deleteOrderGO(id);
        return MessageUtil.success("删除成功");
    }

    @GetMapping("/deleteMore")
    @ApiOperation(value = "批量删除未支付订单")
    @ApiImplicitParam(name = "ids",value = "根据多个id删除未支付订单",paramType = "query",dataType = "int",required = true,allowMultiple = true)
    public Message deleteMore(int[] ids){
        iForPaymentService.deleteMore(ids);
        return MessageUtil.success("删除成功");
    }

    @GetMapping("/GoPayment")
    @ApiOperation(value = "去付款")
    @ApiImplicitParam(name = "id",value = "订单id",paramType = "query",dataType = "int",required = true)
    public void GoPayment(HttpServletRequest request, HttpServletResponse response, int id){
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
            GOExample example = new GOExample();
            example.createCriteria().andOrderIdEqualTo(id);
            List<GO> gos = goMapper.selectByExample(example);
            for(GO go:gos){
                Goods goods = goodsMapper.selectByPrimaryKey(go.getGoodsId());
                subject = goods.getName();
            }

            model.setSubject(subject);
            // 订单描述
            model.setBody(System.currentTimeMillis()+"");

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
    @GetMapping("/callback")
    @ApiOperation(value = "付款回调")
    public String callback(HttpServletRequest request,HttpServletResponse response) throws IOException, AlipayApiException {
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
            iForPaymentService.GoPayment(Integer.parseInt(out_trade_no));

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");

            out.println("trade_no:"+trade_no+"\n");
            out.println("out_trade_no:"+out_trade_no);
            out.println("total_amount:"+total_amount);
            out.println("已付款");

        }else {
            out.println("验签失败");
        }
        return null;
    }
}
