package com.chl.depression.mapper;

import com.chl.depression.bean.InformationDoctor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InformationDoctorMapper {
    List<InformationDoctor> list();
}
