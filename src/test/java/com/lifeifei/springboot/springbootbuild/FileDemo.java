package com.lifeifei.springboot.springbootbuild;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            File file = new File("D:\\" + i + ".bat");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long e = System.currentTimeMillis();
        System.out.println("共计耗时:" + (e - s) + " 毫秒");
    }
}
