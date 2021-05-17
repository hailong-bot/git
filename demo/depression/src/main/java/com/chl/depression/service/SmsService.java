package com.chl.depression.service;

import com.chl.depression.bean.SmsParams;
import com.chl.depression.utils.SmsUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SmsService{

    @Autowired
    SmsUtils smsUtils;

    public String sendCode(String phoNumber){
        String code = SmsUtils.createRandomCode();
        SmsParams smsParams = new SmsParams(code,phoNumber);
        log.info("手机号码为：{}，验证码为：{}",phoNumber,code);
        try {
            String sendSms = smsUtils.sendSms(smsParams);
            log.info(sendSms);

            return code;
        }
        catch (Exception e){
            return "发送验证码问题";
        }
    }
}
