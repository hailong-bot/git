package com.chl.depression.service.impl;

import com.chl.depression.bean.User;
import com.chl.depression.mapper.UserMapper;
import com.chl.depression.service.UserService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;


    @Override
    public User getUser(String phone) {
        User user = userMapper.getUserByPhone(phone);
        return user;
    }

    @Override
    public void insertUser(User user) {
        userMapper.InsertUser(user);
    }

    @Override
    public List<User> userList() {
        return userMapper.userList();
    }

    @Override
    public List<User> doctorList() {
        return userMapper.doctorList();
    }

    @Override
    public String getTypeByPhone(String phone) {
        User user = userMapper.getUserByPhone(phone);
        return user.getType();
    }
}
