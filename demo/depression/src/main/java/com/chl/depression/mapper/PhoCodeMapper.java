package com.chl.depression.mapper;

import com.chl.depression.bean.PhoCode;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Mapper
public interface PhoCodeMapper {
    @Select("SELECT * FROM phoCode WHERE phone = #{phone}")
    public PhoCode getPhoCodeByPhone(String phone);

    @Insert("INSERT INTO phoCode (phone,code,send_date,expiration_date) VALUES (#{phone},#{code},#{send_date},#{expiration_date})")
    public void insertPhoCode(PhoCode phoCode);


    @Update("UPDATE phoCode set code = #{code},send_date = #{send_date},expiration_date = #{expiration_date} Where phone = #{phone}")
    public void update(String code, Date send_date,Date expiration_date,String phone);

    @Select("SELECT * FROM phoCode")
    public List<PhoCode> lis();
}
