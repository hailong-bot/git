package com.chl.depression.utils;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateUtils {
    /**
     * 判断日期是否超过日期一5分钟
     * @param date1
     * @param date2
     * @return
     */
    public boolean isMoreFiveMinutes(Date date1, Date date2){
        long time = date2.getTime() - date1.getTime();
        //计算年
        if(((time / (24 * 60 * 60 * 1000)) / 365) >= 1){
            return true;
        }
        //计算天
        else if((time / (24 * 60 * 60 * 1000)) >= 1){
            return true;
        }
        //计算小时
        else if((time / (60 * 60 * 1000)) % 24 >= 1){
            return true;
        }
        //计算分钟数
        else if(((time / 1000) % 60) >= 5){
            return true;
        }
        else return false;
    }

    public Date addFiveMinutes(Date date) throws ParseException {
        long time = date.getTime();
        time += 300000;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = simpleDateFormat.format(time);
        Date parse = simpleDateFormat.parse(s);
        return parse;
    }
}
