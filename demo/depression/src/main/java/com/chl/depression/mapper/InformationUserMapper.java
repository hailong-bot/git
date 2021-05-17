package com.chl.depression.mapper;

import com.chl.depression.bean.InformationUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface InformationUserMapper {
    List<InformationUser> list();


    /**
     * 添加手机号码
     * @param phone
     */
    @Insert("INSERT into information_user (phone) values (#{phone})")
    public void insertUser(String phone);

    @Update("UPDATE information_user set name = #{name},sex = #{sex},age = #{age} where phone = #{phone}")
    public void perfect_information(String name,String sex,int age,String phone);

    @Update("UPDATE information_user set url = #{url} where phone = #{phone}")
    public void perfect_url(String url,String phone);

    public InformationUser hasUser(String phone);
}
