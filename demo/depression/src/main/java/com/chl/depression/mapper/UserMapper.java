package com.chl.depression.mapper;

import com.chl.depression.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE phone = #{pho}")
    User getUserByPhone(String pho);

    void InsertUser(User user);

    @Select("SELECT * FROM user WHERE type = 02")
    List<User> userList();

    @Select("SELECT * FROM user WHERE type = 01")
    List<User> doctorList();


}
