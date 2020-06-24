package com.lifeifei.springboot.springbootbuild.mode.vo;

import lombok.Data;

import java.util.List;

/**
 * @author:容合
 * @create:2020-06-18 11:
 * @description:
 */
@Data
public class QiRobotVo {
    /**
     * 机器人id
     */
    private String robotId;
    /**
     * 机器人名字
     */
    private String robotName;
    /**
     * 当前机器人的webhook地址
     */
    private String webhookAddress;


    /**
     * 消息类型
     */
    private String msgType;

    /**
     * 富文本框里面的内容
     */
    private String content;
    /**
     * 涉及的人员
     */
    private List<String> memberList;
    /**
     * 电话
     */
    private String mobileList;
    /**
     * 图片地址
     */
    private String imageUrl;

    /**
     * base64编码后的值
     */
    private String imageBase64Value;

    /**
     * 图片md5加密后的值
     */
    private String imageMd5Value;

    /**
     * 发送消息的标题
     */
    private String title;
    /**
     * 发送图文消息的描述信息
     */
    private String description;
    /**
     * 图片url地址集合
     */
    private List<String> imageUrlList;
    /**
     * 图片打开的地址
     */
    private String url;

    /**
     * 消息内容集合
     */
    private List<String> contentList;
    /**
     * 图片路径
     */
    private String savePath;
}
