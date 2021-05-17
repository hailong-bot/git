package com.chl.depression.service;

import com.chl.depression.bean.User;

import java.util.List;

public interface UserService {

    public User getUser(String phone);

    public void insertUser(User user);

    public List<User> userList();

    public List<User> doctorList();

    public String getTypeByPhone(String phone);
}
