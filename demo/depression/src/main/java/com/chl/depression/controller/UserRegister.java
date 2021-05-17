package com.chl.depression.controller;

import com.chl.depression.bean.PhoCode;
import com.chl.depression.bean.User;
import com.chl.depression.service.InformationUserService;
import com.chl.depression.service.PhoCodeService;
import com.chl.depression.service.UserService;
import com.chl.depression.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
public class UserRegister {

    @Autowired
    PhoCodeService phoCodeService;

    @Autowired
    UserService userService;

    @Autowired
    DateUtils dateUtils;

    @Resource
    InformationUserService informationUserService;

    @PostMapping("/register")
    public String userRegister(@RequestParam("phone") String phone,
                               @RequestParam("password") String password,
                               @RequestParam("code") String code,
                               @RequestParam("type") String type){
        User user = userService.getUser(phone);
        if(user != null){
            return "账号已注册";
        }
        else{
            PhoCode phoCode = phoCodeService.getPhoCodeByPhone(phone);
            if(phoCode != null){
                Date now = new Date();
                if(dateUtils.isMoreFiveMinutes(now,phoCode.getExpiration_date())){
                    return "验证码已过期,请重新发送验证码";
                }
                else{
                    if(code.equals(phoCode.getCode())){
                        User user1 = new User();
                        user1.setPhone(phone);
                        user1.setPassword(password);
                        Date create_time = new Date();
                        Date update_time = create_time;
                        user1.setCreate_time(create_time);
                        user1.setUpdate_time(update_time);
                        user1.setType(type);
                        userService.insertUser(user1);

                        if(informationUserService.hasUser(phone)){

                        }
                        else{
                            informationUserService.insertUser(phone);
                        }
                        //只添加了user表
                        //user信息表还未添加

                        return "注册成功";
                    }
                    else{
                        return "验证码错误";
                    }
                }
            }
            else{
                return "并没有发送验证码";
            }
        }
    }
}
