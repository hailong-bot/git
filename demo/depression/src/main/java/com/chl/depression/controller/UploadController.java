package com.chl.depression.controller;

import com.chl.depression.service.InformationUserService;
import com.chl.depression.service.UserService;
import com.chl.depression.utils.FileNameUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
public class UploadController {


    @Resource
    FileNameUtils fileNameUtils;

    @Resource
    InformationUserService informationUserService;

    @Resource
    UserService userService;

    @RequestMapping("/uploadImage")
    public String uploadImage(@RequestParam("img") MultipartFile img,String phone) throws IOException {
        String path = fileNameUtils.fileName() + "_" + img.getOriginalFilename();
        String dest = "E:/images/" + path;
        File file = new File(dest);
        img.transferTo(file);


        try {
            String type = userService.getTypeByPhone(phone);
            //表明是医生
            if(type.equals("01")){

            }
            //表明是患者
            else{
                String url= "http://localhost/" + path;
                informationUserService.perfect_url(url,phone);
            }
        }
        catch (Exception e){

        }
        return "接受到文件";
    }

}
