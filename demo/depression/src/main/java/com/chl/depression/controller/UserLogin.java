package com.chl.depression.controller;

import com.chl.depression.bean.LoginCode;
import com.chl.depression.bean.User;
import com.chl.depression.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLogin {

    @Autowired
    UserService userService;


    /**
     * 01 表示医生
     * 02 表示用户
     * @param pho
     * @param password
     * @return
     */
    @PostMapping("/login")
    public LoginCode login(@RequestParam("pho") String pho,
                           @RequestParam("password") String password){
        System.out.println(pho);
        System.out.println(password);
        User user = userService.getUser(pho);
        LoginCode loginCode = new LoginCode();
        if(user != null){

            if(password.equals(user.getPassword())){
                loginCode.setMsg("登录成功");
                loginCode.setType(user.getType());
            }
            else{
                /**
                 * 03表示为空
                 */

                loginCode.setMsg("密码错误");
                loginCode.setType("03");
            }
        }
        else{
            /**
             * 04 表示不存在
             */

            loginCode.setMsg("账号不存在");
            loginCode.setType("04");
        }
        return loginCode;
    }
}
