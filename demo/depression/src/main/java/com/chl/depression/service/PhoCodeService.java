package com.chl.depression.service;

import com.chl.depression.bean.PhoCode;

import java.util.Date;
import java.util.List;

public interface PhoCodeService {
    public PhoCode getPhoCodeByPhone(String phone);

    public void insertPhoCode(PhoCode phoCode);

    //public void update(String code, Date send_date,Date expiration_date,String phone);
    public void update(String code, Date send_date,Date expiration_date,String phone);

    public List<PhoCode> lis();
}
