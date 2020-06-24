package com.lifeifei.springboot.springbootbuild.controller;

import com.lifeifei.springboot.springbootbuild.utils.TranscodingUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author:容合
 * @create:2020-06-18 15:
 * @description: 将浏览器页面生成的数据转换成图片
 */
@RestController
public class GeneratePictureController {

    @PostMapping("/images")
    public void generatePicture() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("/usr/local/test/template1.html"));
        String s = IOUtils.toString(fileInputStream, StandardCharsets.UTF_8);
        try {
            TranscodingUtils.html2Img(s, new File("/usr/local/test/template1.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
