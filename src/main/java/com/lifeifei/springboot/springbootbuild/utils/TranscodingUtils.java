package com.lifeifei.springboot.springbootbuild.utils;

import gui.ava.html.image.generator.HtmlImageGenerator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

/**
 * @author:容合
 * @create:2020-06-18 11:
 * @description:
 */
public class TranscodingUtils {
    /**
     * 根据图片地址转换为base64编码字符串
     *
     * @param imgFile
     * @return
     */
    public static String getImageStr(String imgFile) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(data);
    }

    /**
     * @param htmlContent HTML文本字符串
     * @return 希望生成的Image Location
     * @Description HTML转Image
     */
    public static void html2Img(String htmlContent, File imagePath) throws Exception {
        HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
        imageGenerator.loadHtml(htmlContent);
        imageGenerator.saveAsImage(imagePath);
    }
}
