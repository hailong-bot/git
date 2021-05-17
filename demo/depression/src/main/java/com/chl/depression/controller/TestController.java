package com.chl.depression.controller;

import com.chl.depression.bean.PhoCode;
import com.chl.depression.service.PhoCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    PhoCodeService phoCodeService;

    @GetMapping("/list")
    public List<PhoCode> list(){
        return phoCodeService.lis();
    }
}
