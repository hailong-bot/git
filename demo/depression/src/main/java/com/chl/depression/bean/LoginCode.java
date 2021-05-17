package com.chl.depression.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录返回信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class LoginCode {
    String msg;

    String type;
}
