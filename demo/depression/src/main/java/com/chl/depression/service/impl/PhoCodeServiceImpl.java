package com.chl.depression.service.impl;

import com.chl.depression.bean.PhoCode;
import com.chl.depression.mapper.PhoCodeMapper;
import com.chl.depression.service.PhoCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class PhoCodeServiceImpl implements PhoCodeService {


    @Resource
    PhoCodeMapper phoCodeMapper;

    @Override
    public PhoCode getPhoCodeByPhone(String phone) {
        PhoCode phoCode = phoCodeMapper.getPhoCodeByPhone(phone);
        return phoCode;
    }

    @Override
    public void insertPhoCode(PhoCode phoCode) {
        phoCodeMapper.insertPhoCode(phoCode);
    }

    @Override
    public void update(String code, Date send_date, Date expiration_date, String phone) {
        phoCodeMapper.update(code,send_date,expiration_date,phone);
    }

    @Override
    public List<PhoCode> lis() {
        return phoCodeMapper.lis();
    }
}
