package com.chl.depression.controller;

import com.chl.depression.bean.PhoCode;
import com.chl.depression.service.PhoCodeService;
import com.chl.depression.service.SmsService;
import com.chl.depression.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;

@Slf4j
@RestController
public class SmsController {
    @Autowired
    SmsService smsService;

    @Autowired
    PhoCodeService phoCodeService;

    @Autowired
    DateUtils dateUtils;


    @GetMapping("/sms")
    public void sendSms(@RequestParam("phoNumber") String phoNumber) throws ParseException {

        PhoCode phoCode = phoCodeService.getPhoCodeByPhone(phoNumber);
        System.out.println(phoCode);
        if(phoCode != null){
            Date now = new Date();
            if(dateUtils.isMoreFiveMinutes(phoCode.getExpiration_date(),now)){
                //update
                String code = smsService.sendCode(phoNumber);
                Date send_date = new Date();
                Date expiration_date = dateUtils.addFiveMinutes(send_date);
                phoCodeService.update(code,send_date,expiration_date,phoNumber);
            }
            else{
                //验证码有效时间还在

            }
        }
        else {
            String code = smsService.sendCode(phoNumber);
            Date send_date = new Date();
            Date expiration_date = dateUtils.addFiveMinutes(send_date);

            System.out.println(code);
            System.out.println(send_date);
            System.out.println(expiration_date);

            /**
             * phoCode为空
             */
            phoCode = new PhoCode();
            phoCode.setCode(code);
            phoCode.setSend_date(send_date);
            phoCode.setPhone(phoNumber);
            phoCode.setExpiration_date(expiration_date);
            phoCodeService.insertPhoCode(phoCode);
        }

    }
}
