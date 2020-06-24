package com.lifeifei.springboot.springbootbuild.service;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.lifeifei.springboot.springbootbuild.mode.vo.QiRobotVo;

import com.lifeifei.springboot.springbootbuild.utils.RequestSendUtils;
import com.lifeifei.springboot.springbootbuild.utils.TranscodingUtils;
import com.sun.imageio.plugins.common.ImageUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @author:容合
 * @create:2020-06-18 11:
 * @description:
 */
@Service
@Slf4j
public class WechatTemplateService {

    public void testSendNews(QiRobotVo vo) throws Exception {
        List<String> memberList = vo.getMemberList();
        String jsonData = "";
        String mobileList = "";
        String strMember = "";
        if (vo.getMsgType().equals("text")) {
            if (!Strings.isNullOrEmpty(vo.getMobileList())) {
                mobileList = vo.getMobileList();
            } else {
                mobileList = "";
            }
            for (int i = 0; i < memberList.size(); i++) {
                if (i == memberList.size() - 1) {
                    strMember += "\"" + memberList.get(i) + "\"";
                } else {
                    strMember += "\"" + memberList.get(i) + "\"" + ",";
                }
            }
            String[] members = new String[memberList.size()];
            for (int i = 0; i < memberList.size(); i++) {
                members[i] = memberList.get(i);
            }
            jsonData = "{\n" +
                    "\t\"msgtype\": \"" + vo.getMsgType() + "\",\n" +
                    "    \"text\": {\n" +
                    "        \"content\": \"" + vo.getContent() + "\",\n" +
                    "        \"mentioned_list\":[" + strMember + "],\n" +
                    "        \"mentioned_mobile_list\":[\"" + mobileList + "\"]\n" +
                    "    }\n" +
                    "}";

        } else if (vo.getMsgType().equals("image")) {
            //图片base64加密的值
            vo.setImageBase64Value(TranscodingUtils.getImageStr(vo.getSavePath()));
            FileOutputStream fos = new FileOutputStream(new File("F:/test.txt"), true);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            bos.write(TranscodingUtils.getImageStr(vo.getSavePath()).getBytes());
            bos.flush();
            bos.close();
            //图片md5加密的值
            vo.setImageMd5Value(DigestUtils.md5Hex(new FileInputStream(vo.getSavePath())));

            jsonData = "{\n" +
                    "    \"msgtype\": \"" + vo.getMsgType() + "\",\n" +
                    "    \"image\": {\n" +
                    "        \"base64\": \"" + vo.getImageBase64Value() + "\",\n" +
                    "        \"md5\": \"" + vo.getImageMd5Value() + "\"\n" +
                    "    }\n" +
                    "}";
        } else if (vo.getMsgType().equals("news")) {
            //图文消息
            vo.setTitle(!Strings.isNullOrEmpty(vo.getTitle()) ? vo.getTitle() : "");
            jsonData = "{\n" +
                    "    \"msgtype\": \"" + vo.getMsgType() + "\",\n" +
                    "    \"news\": {\n" +
                    "       \"articles\" : [\n" +
                    "           {\n" +
                    "               \"title\" : \"" + vo.getTitle() + "\",\n" +
                    "               \"description\" : \"" + vo.getDescription() + "\",\n" +
                    "               \"url\" : \"" + vo.getUrl() + "\",\n" +
                    "               \"picurl\" : \"" + vo.getImageUrl() + "\"\n" +
                    "           }\n" +
                    "        ]\n" +
                    "    }\n" +
                    "}";
        }
        JSONObject jsonObject = RequestSendUtils.sendPost(vo.getWebhookAddress(), jsonData);
    }
}
