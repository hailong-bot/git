package com.chl.depression.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SmsParams {
    /**
     * 验证码
     */
    private String verifyCode;


    /**
     * 手机号码
     */
    private String phoneNumber;
}
