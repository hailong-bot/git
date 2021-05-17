package com.chl.depression.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UploadImageMapper {
    @Update("update information_user set url = #{url} where phone = #{phone}")
    public void updateUserUrl(String url,String phone);
}
