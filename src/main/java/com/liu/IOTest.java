package com.liu;

import java.io.File;

public class IOTest {
    public static void main(String[] args) throws Exception {
        getDirectoryOrFile("C:\\Users\\root\\Desktop\\gaga");

    }

    public static void getDirectoryOrFile(String path) {
        File file = new File(path);
        boolean isFileexists = file.exists();
        if (isFileexists) {
            if (file.isDirectory()) {
                // TODO: 2019/10/14 列出目录下所有文件及子目录下的文件
                File[] fileList = file.listFiles();
                for (File tempFile : fileList) {
                    if (tempFile.isDirectory()) {
                        //System.out.println("目录：");
                        getDirectoryOrFile(tempFile.getAbsolutePath());
                    } else {
                        System.out.println("文件：" + tempFile.getAbsolutePath());
                    }
                }
            } else if (file.isFile()) {
                System.out.println("文件");
                System.out.println(file.getName());
                System.out.println(file.getAbsolutePath());
            } else {
                System.out.println("不是正确的文件或路径");
            }
        } else {
            System.out.println("文件或目录不存在");
        }
    }
}
