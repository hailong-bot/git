package com.chl.stream;

import java.io.File;
import java.io.IOException;

public class MyFile {
    /**
     * 主函数入口
     * @param args
     */
    public static void main(String[] args){
        String fileName = "1.txt";
        MyFile.createFile(fileName);
        System.out.println("创建文件成功");
    }


    public static void createFile(String fileName){
        File file = new File("C:\\Users\\admin\\Desktop\\javaIO\\" + fileName);

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
