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
    public static String app_id = "2016101900725219";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCFwyDChhmiWnP+zOQe3yxEMuzbf3EZaNtMuRYf62VSgNfG3tcMfqPs7bsNURUHRnYPgiw+r0I/eUAGzVq0CHJsl3Y9cHhrI1qcp9uvV7Z2zYofsSzalUxgpWEv5Y4QZ5ONAFi6oyTm7yJ8pZSDqlLna4b4BitqBMnxQHThn8Fcs3Jhpprzei/1DEeiX5Hdcq5lgvi9UKfP1ll66wVe9Y7ISv/iz+bV97CcIaXg6Vm52usqVOViTtP0WDTyB/Iu7ZL2VTRMXueVENLpq+rhLDcxBBRxFc+FxOO5+NFfazJ81oJOM/svAsQGkbkimrPyfx6pJvMqN/G7IddWvgMs2jXtAgMBAAECggEBAIUjw+fbMoi3H93ucuGHobgAOGICZ8Cy7hVf5PXAiAmm1R/Njp+RLfkWZ6jJm/Sx3bFyEDgUmgwz09bxb+biwYH1AGwHFtUNS5PCQJg25hc6XtFMuSiYkn1gH2xdQRpy/hrKzYZ3/LMgM2N+LGUhk4NlM+KLwYq1WYwYbD5nlT9+rV0eYHtTFmwayH7/2OT4Y6b1UsLSFqx7A/Kn6fOh9V+YidaDo3B7+NkmAXJqOf6lmgFBNAWsmhYwFT+8BWcGt8xT7rJJhrPoUb0bWNHgzd7xkaQ2N/9SGzmIIzsUvnSWAjY0w10iSGr+NzttThHuQIqvDwV0hNbExaFUoWlJ4AECgYEAvBQolbB7JN/zEOgFYKSZiFhAXIgp64Onrqx/9OKhaKu1HqHvAi3O7WPvSEU0ErOwPSwCeClNGeHuUdQkbW2T6GrDkwhdfKkU53vnrfaAWem33UFwJzpA+ZX72Tf0I3r134Mgr/befsYxeD5vTU84nGwqVXk/FbkMxKtscgS/220CgYEAthFq8QE9Y16/d42MpT3Nv+SZWX3IInbvv6mDYMAYtoaFxK/nQkMxdDVAAzfzJBPLRAmkqZnUFBqJXQ7ga/DV70ooORIN4LpyEhY/OQjWD6NaFxO8p2Tn9mbpE8UKNDS4jGRCOWEPNrHQU8DtAw3IqlOn722FOGSAVaS/gPb0tIECgYAvS2JpQde1jhsxRScVBk8VWhvVKOhhsNmZswb6LYMpLwR8j3vqsFo4l8i0A7L0gPrwZwC39qrMt2OWcCI44jUvXKmRb6kSj/IRw7aeqD3eXkc9/BaXxq5QFMcf+FIMGf96FR9DIHESsAQAmLKkXid+LjT3CWYzsDTlv7WldkxIgQKBgGawhETSkjFN62ge6kj5BudIpEWZcBwgQTE1Bui28DlivmglXqY9B9OnhSdLk1Ox5l/FoJ4YKUn9faSDE4lOGRwSE4W87R7nihcxfQ9KMJI5bEK/2xP/EeYkPSntZMf1RHHKyp9aYx5SRFI46nVifN+0t2+PsigQZ2HmviybHYIBAoGASU30pGSybQar+KJZIv+ytrKBjixGum9M5FpBew8f1fLVSgmliCoL0Xs7BO8EPFxloMxwGFw9w3xNy5e80g8EK9TPN9zjmF+KApshyQXGNfqSCY56VcjCA1XToetkVAhTLudhG/ZwdyBpuRsRJyON3hDOBH+/ZxO2zG3rwjEKjPk=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyxwABzqEptVrdrAecez3Z6/pwemuM+bKw3qmpRHbXe9AyocgejrJf91pawzlB7lvitXjBCdANSWyt8NLp4tiIPqrlBVisTE/cCnkzu+MkuXGFnVG4mRCoLGTgJkQaMwOH+5Qx0Mmjp/7lr3ONg6oJIYQKaHqFsxn84ImQh5QbwSzYG12XJ0QlvoABrCbImN1EaYopfViMKDaKZNxL6JchcrSH/BjXs3yJwObJ+zng39e3efvTj72X+iF0QEk1F62fVd4BCeCQbqqtoy427lwITipLNmfAeguULq77/7uE0rlcxAxkg3XkgYA+uUQ/DLqdM5kPEnBSVmM72tNZJYcYQIDAQAB";

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
