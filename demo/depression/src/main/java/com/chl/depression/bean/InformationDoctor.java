package com.chl.depression.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class InformationDoctor {

    String phone;

    String name;

    String sex;

    int age;

    //主治
    String indications;

    //详细信息
    String detailed_information;

    //科室
    String department;

    //图像url
    String url;

    //工作地址
    String address;

}
