package cn.swu.pigeon.configuration;

import java.io.FileWriter;
import java.io.IOException;


public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号,开发时使用沙箱提供的APPID，生产环境改成自己的APPID
    public static String APP_ID = "2021000116677446"; //测试

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCOW3IhomeToU1grmTboa0Yeg5ZmKB2HPSNM5NSRkS9pFjUaAg+dp6P+rTBKrFm/JTpVWPIVTm0DWq+AxxyrCa79mpwBl0NaCrImC5tY+GYh5AR5X7PvF8VPx9Ne+K2H7ppcxhZYtm+DKdPy8DRv1oElX/AGf0+A6i7co5UHcpox25Rcl8lSNmOCdcx7pKMOTGShHQInig7dVQJrOy0SNAal6wpBe8l2uNr+LfZeJ+jIrT/5GIXofOoxWtO58HH9dGw/sb6kDv4nO8K/jxFSSti/WAN8iUU/1OX0jiy546zmEs/UEcPlQdU1mlTApNsK92WT/OViNlNxCDt4pCBanUZAgMBAAECggEAPVQ0JT1cNgPF3CMFnIFYmzTqPbs9VeU/jh1sGIPhVXoaMtfmxVJBGXI+sQF9kAq89JEu/b2JsIIfPGEGvnhf75ZHYJ+9Mutvkx/M0J+5LwcoEC24pjJXHEYnbDA1CZU9r/Q/xzKI8BFvezciiLpRQ6xMbyxDJ5ZX+PlvS9nRu7WaOuY9n7/XSQ9hBtebxIGg136vQNYZMFXdMirwL6OckOwqWqrzZMMv5jLD9S1xiFipL3KdMTr89kfRrgjWyALRltK7q/FSsl8cbFR4/fRKaLr3ECWlHf/6YxHcyOKOZVilSM9GFm8D/X5svPfdxVX6Qlb6WFrKf+KWRoK/+JcKAQKBgQDQQ8z8KFta+qyJxbKUTf2oqECwzjZzpDJto20up+F345R46SUI6AcElLslFUCF6NERwCS3OylpDlR1BnnTbXuUe1oGw5+Y4w/LaNWgkAQKc2HWNGZ+0ruDdkURmGKzw8OHrGaKxpfA7aFPklrcCSi58VXNjIY8+mcNLhxMelTdOQKBgQCu/G61GX5ucjoxo6WHSCzxVu3MxWQmofgVKsktkX3+B2KzheaccCUIcjWFM+BqVgkDvWuXdYWGE41g7mge6LUWjP4vHfXRT5m8OCgEFZ+UHWuOrnhvFG4P5kAaHN0/Zqej8+z90xt27PFwnuboP1g6ePRNnCics0iQ4g6P8Xo24QKBgGRb18LHO8aqt0wovXZj4tFMSugoZurw+/ADadCqy6a3P0vIpbUWApO9jDVBeXdOCrlwCwFU/A6I/j/qX/h3cK7LhkVuLVFCUdEmcpNN8vSKR2IunBmPORcPfhcNhLq1olqVxFAphOVOXYZ3s1sG+t4nor5LckCeNdyPFMnxxUVZAoGBAKamdIz3Faj8Ep4Z21hmjZ7fCiSdzQ7Z7JnEIMrMKHDY+dA9cu6EA1Dy7DPKvyymeXldWe1qGFsjnd61zuW4/FXYu2+GGglYxPIzjTCuo0b9aeT+Fma7z0JHJ792w+NQ0dFcStVFy39Mk3iNbR28zjsJ3KlZUnhCapbJI9NEx/8hAoGAFP2Y3iRFNVDt7gvGEgrTIZZYpO/WFK2ze2CI/PtWLCsKrlHw7hCLdb0pG+NKUz5LuFeqXM3wMoxDqJpTz0TU951YdI6vjTfxFewm6sj68wYDb6xyV+A2Jy1ioTXXWdpIsSKMTMO7cFEPbDvR3R1k3x3QQPo6QaxX1/J2x8Rlxfk=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    //public static String ALIPAY_PUBLIC_KEY = "在沙箱应用中对应的支付宝公钥";
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjBy5VGa8J2aWpol00AflpwQZYvzdU51A7dg5HUbwhzmbRpeY1sHTUYUf+TvrDpCeE6/fRx+rNmz/Mtp3M+uaVXFfJreTAveyAtB7no8a575O9GZJHX0SFz4m25eizUkZP6yFwXz5VfpNW2t20qT2Uk/KUVZMVRJO3kU1F+KNhZ5/pSrBMkGEKHWWRNPoBCrW0u6IhtAiCGL+cVBahk88I3lnoRtnvx226piXq3BIsL+nTxDmF8gHIIVC/KCdbwvZTIW9q5jxer6crrHAqesXiy7T9oEeXoMfXWoB47sLwWdrfLoasmDs0GV6XcoZHXQYCbarNOhoxxgkvwYyDKhOTwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8989/api/pigeon/Alipay/notifyUrl";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问(其实就是支付成功后返回的页面)
    public static String return_url = "http://localhost:8989/api/pigeon/Alipay/returnUrl";
    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String CHARSET = "UTF-8";

    // 支付宝网关，这是沙箱的网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do"; //测试

    // 支付宝网关
    public static String log_path = "E:\\";

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
}
