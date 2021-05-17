package com.chl.depression.controller;

import com.chl.depression.bean.InformationUser;
import com.chl.depression.bean.User;
import com.chl.depression.service.InformationUserService;
import com.chl.depression.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class UserController {

    @Resource
    UserService userService;

    @Resource
    InformationUserService informationUserService;


    @GetMapping("/userList")
    public List<User> listUser(){
        return userService.userList();
    }

    @GetMapping("/informationUserList")
    public List<InformationUser> informationUserList(){
        return informationUserService.list();
    }

    @GetMapping("/addInformationUser")
    public String insert_user(@RequestParam("phone") String phone){
        try{
            if(informationUserService.hasUser(phone)){
                return "用户已创建";
            }
            informationUserService.insertUser(phone);
            return "创建用户成功";
        }
        catch (Exception e){
            return "创建用户失败";
        }
    }


    @PostMapping("/perfectInformationUser")
    public String perfect_information(String name,String sex,int age,String phone){
        try{
            if(informationUserService.hasUser(phone)){
                informationUserService.perfect_information(name, sex, age, phone);
                return "更新信息成功";
            }
            return "号码未注册";
        }
        catch (Exception e){
            return "更新信息失败";
        }

    }
}
