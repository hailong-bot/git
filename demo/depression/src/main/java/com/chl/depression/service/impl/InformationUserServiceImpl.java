package com.chl.depression.service.impl;

import com.chl.depression.bean.InformationUser;
import com.chl.depression.mapper.InformationUserMapper;
import com.chl.depression.service.InformationUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service

public class InformationUserServiceImpl implements InformationUserService {

    @Resource
    InformationUserMapper informationUserMapper;

    @Override
    public List<InformationUser> list() {
        return informationUserMapper.list();
    }

    @Override
    public void insertUser(String phone) {
        informationUserMapper.insertUser(phone);
    }

    @Override
    public void perfect_information(String name, String sex, int age, String phone) {
        log.info("name1:" + name);
        log.info("sex1:" + sex);
        log.info("age1:" + age);
        log.info("phone1:" + phone);
        informationUserMapper.perfect_information(name,sex,age,phone);
    }

    @Override
    public void perfect_url(String url, String phone) {
        informationUserMapper.perfect_url(url,phone);
    }

    @Override
    public boolean hasUser(String phone) {
        InformationUser user = informationUserMapper.hasUser(phone);
        System.out.println("-------" + user);
        if(user == null){
            return false;
        }
        else{
            return true;
        }
    }
}
