package com.chl.depression.controller;

import com.chl.depression.bean.InformationDoctor;
import com.chl.depression.bean.User;
import com.chl.depression.service.InformationDoctorService;
import com.chl.depression.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

@RestController
public class DoctorController {

    /**
     * 返回医生信息表
     * @return
     */

    @Resource
    UserService userService;

    @Resource
    InformationDoctorService informationDoctorService;


    @GetMapping("/doctorList")
    public List<User> list(){
        return userService.doctorList();
    }

        @GetMapping("/doctorInformationList")
    public List<InformationDoctor> informationList(){
        return informationDoctorService.list();
    }
}
