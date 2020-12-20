package cn.swu.pigeon.utils;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;


import java.io.IOException;
import java.util.Random;

public class sendSMSUtil {
    //public static void main(String[] args) {
    public void send(String phoneNumber){
        //腾讯短信应用的 SDK AppID
        int appid = 1400460644;
        String appkey = "e96d013cf5a8e30801b2baf75944984d";//腾讯云短信中的 App Key
        int templateId = 817552;// NOTE: 这里是短信模板ID需要在短信控制台中申请
        String smsSign = "yuswwork网";//设置信息标头，如【腾讯云】
        //验证码
        String str = "";
        try {
            //随机生成6位的验证码
            Random random = new Random();
            for (int i = 0; i < 6; i++) {
                str += random.nextInt(10);
            }
            String[] params = {str, "2"};
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            // 签名参数未提供或者为空时，会使用默认签名发送短信，这里的13800138000是为用户输入的手机号码
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumber, templateId, params, smsSign, "", "");
            System.out.println(result);
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
    }
}