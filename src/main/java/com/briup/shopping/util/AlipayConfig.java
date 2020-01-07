package com.briup.shopping.util;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016102100731765";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCPHgs8eYRjlGJmWuatPAQm5+Q+0emqpTBEedypBSADEdaTD1fPBTLl8XfdPXKWfvFa4LzupFRaYIZ158VSHiO8EGzSDz7Uhs5qqiFSNAfurz037slo9gNxyQnT7WOsyIMDUQtives7vpEJEkL2cwH8M72PeOCygqIxMlwRB89kgZ9x+7nEq7CEtIYmPY44eMmelM+KKKZdJDx2OSEOWRClWquD9sgRtslrENCR1meKmeXZ1GZhZ/WHI9lYNZh8K0/DG3es++lrozuHJsnngDawQYw6mnAU2V0jhR6BvS9+rHFPXpvB95JwCoaK6jyEiHaGZb2fAhNU3d+GtsEYe69vAgMBAAECggEATVMtPPpm1iqo06aPdc+0apTl1C80MbfYkVbKKyQSvLXZmlEy3y5u5qAFZCq8C6YAn1pHmiR9UutOGswj549TPVwef4wvJULEqgrLwA9Ord5OlDbW6XfqOoMlZTSgow0fBB64qRv1yazXze/o8CEJVItcAvWLacd8/Fm6NpVir2kutz04mPPX+PNjC3qpcjc7rKwf+BhyZuUEAJepEf14fWPPFYXtT3N42TMaE1Zz3yR9ZFu58m9w9ZDTTpigmQml1efmkyRDCVy6p++LCbQkCkwp93KbCfLOhKBGw2uTDKFcyW/px+UMo29llRti8eHDt9JoT5R7z5jLixUW9VVwiQKBgQC/b8pJGBqLfv2cfDZ5Jc3AK+I05NrDfHr/RdzFE43VKMj9DSW7jatcP/PKwHs8cRdH3vsrNI5so7sLFFzz21xvFF+etvlmohvSf4jpPEc+6zoDXzalwR0y1bSou6WPc6B0HJorERqbVTvKiAIbxZyC0iXUnwwYXcqrxVma8QOhowKBgQC/YnkLlfTJSO1nXqMudSefIm8St3ZmAIM33uBKh4oq/TxUjUtBYnTgzeDTTqbn/t2kxuioR2jC7dnNGu7shhIO0bLxs3fIwLIhiz2zJBilMAz6CtW4o5UBWesgwsHElMHQxctzl2apAUHXBoWZjcaOG1EYLKR7sskAcGg/GeVPxQKBgG/mRHPdZwbLQCtMX/sIofAGtr78VvOVu7+jcpywBWPn5zQjjz7GXLgbmcGWKXL3GAimymJC4k2WlyquyHaybqFvY0U+5yGa+HBepATRe0PH860s5qCU9SBV0rgel3P2vn+giG1MHiVV+RE11yWsqQO/GuXh4gwMJv+o5+utndXJAoGAGddhArh3uen37DoyDGbTN8B9gOh2uyUckqGsZUPR2yYgTEZbv/NcVrJVxhJbpP2bzdDxvy8NLSzSeMhHNHaR36Be6hXSea/THYZgiVy5WyyWw/hMjUbBKtKKVf0WDsYLOXZLl0r9GJrL2g3OYkJraeq0U3BLsUwdqcqDuOl1NgUCgYB/wG3qyzPfqsRlpGu7sNmEUiLe0j3is2JmbBvMEAoLIJ81FcGreVcH1/K6pnq/qb/Vdw56Wc6wXz9/Sef0zfs5Jz4lWgYewcBqL+aMSKIPz9ejslIDFjQevubhr7zpF18PUFriyI9/NFWsLyXHXkv1BEh5yRPUStTg90uMSCM0Gg==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6gJKetl9iKvkvVIYbZuitxHmbF0H0DH6I+5HhkOiycO/fpi+hvGDes0oiLBiQeCC0RYiuALZ4GAXQrd57I71KjqqwK6UJSDQxSraT2pN+QPIxd1+hTSl4tUBPlPzcCykC25WTmI9MFEGwZhB53UqqV2ajbTy1UV3C5FCygcWz3KEsDoRENZrT9CSi9nNNAiX2mytpVPeQWD3kvpDGu23KuUyBdsm/xnYjOdhvhbYtfIVG9SA6Qwds+kc4vksMePonGiXRYHWhMew897HepTPAKm/sGL+u+FmD/6LrR4LSeKlQiclh4eOoPdn8gWvnA2x99E4g2JCJolNwZhciv9foQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:9999/jsp/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:9999/ForPayment/callback";


    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static AlipayClient getAlipayClient() {
        // 获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        return alipayClient;
    }

}
