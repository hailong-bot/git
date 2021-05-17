package com.chl.depression.utils;

import com.chl.depression.bean.SmsParams;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SmsUtils {
    //短信应用SDK AppID
    @Value("${tx.sms.appId}")
    private  int appId;

    //短信应用
    @Value("${tx.sms.appKey}")
    private  String appKey;

    //短信模板id
    @Value("${tx.sms.templateId}")
    private  int templateId;

    //签名
    @Value(("${tx.sms.smsSign}"))
    private  String smsSign;

    /**
     * 随机数验证码
     * @return
     */
    public static String createRandomCode(){
        String code = "";
        for(int i = 0; i < 5; i ++){
            code = code + (int)(Math.random() * 9);
        }
        return code;
    }

    public  String sendSms(SmsParams smsParams){
        String rep = "error";
        try{
            String verifyCode = smsParams.getVerifyCode();
            String[] params = {verifyCode};
            SmsSingleSender singleSender = new SmsSingleSender(appId,appKey);
            SmsSingleSenderResult smsSingleSenderResult =
                    singleSender.sendWithParam("86",smsParams.getPhoneNumber(),templateId,params,smsSign,"","");
            System.out.println(smsSingleSenderResult);
            if(smsSingleSenderResult.result == 0){
                rep = "success";
            }
            else{
                rep =  smsSingleSenderResult.errMsg;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (HTTPException e) {
            e.printStackTrace();
        } catch (JSONException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return rep;
    }

}
