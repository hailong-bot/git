package com.chl.depression.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class InformationUser {
    String phone;

    String name;

    String sex;

    int age;

    String url;
}
