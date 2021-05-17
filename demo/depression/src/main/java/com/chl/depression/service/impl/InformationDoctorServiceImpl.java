package com.chl.depression.service.impl;

import com.chl.depression.bean.InformationDoctor;
import com.chl.depression.mapper.InformationDoctorMapper;
import com.chl.depression.service.InformationDoctorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InformationDoctorServiceImpl implements InformationDoctorService {

    @Resource
    InformationDoctorMapper informationDoctorMapper;

    @Override
    public List<InformationDoctor> list() {
        return informationDoctorMapper.list();
    }
}
