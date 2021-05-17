package com.chl.depression;

import com.chl.depression.bean.PhoCode;
import com.chl.depression.utils.DateUtils;
import com.chl.depression.utils.FileNameUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@SpringBootTest
class DepressionApplicationTests {

    @Autowired
    DateUtils dateUtils;

    @Resource
    FileNameUtils fileNameUtils;

    @SneakyThrows
    @Test
    void contextLoads() {
        System.out.println(fileNameUtils.fileName());

    }
}
