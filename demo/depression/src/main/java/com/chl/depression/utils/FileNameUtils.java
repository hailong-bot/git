package com.chl.depression.utils;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FileNameUtils {
    public String fileName(){
        Date date = new Date();
        return String.valueOf(date.getTime());
    }
}
