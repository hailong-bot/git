package com.chl.depression.service;

import com.chl.depression.bean.InformationUser;

import java.util.List;

public interface InformationUserService {
    public List<InformationUser> list();


    public void insertUser(String phone);

    void perfect_information(String name,String sex,int age,String phone);

    void perfect_url(String ur,String phone);

    boolean hasUser(String phone);

}
