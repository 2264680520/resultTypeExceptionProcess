package com.lifeifei.springboot.springbootbuild.controller;

import com.lifeifei.springboot.springbootbuild.mode.vo.QiRobotVo;
import com.lifeifei.springboot.springbootbuild.service.WechatTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:容合
 * @create:2020-06-18 11:
 * @description:
 */
@RestController
public class WechatRobotController {
    @Autowired
    WechatTemplateService wechatTemplateService;

    @GetMapping(value = "/testApi4")
    public void testBosRoBot() throws Exception {
        QiRobotVo vo = new QiRobotVo();
        //机器人地址
        vo.setWebhookAddress("https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=a221fd90-3967-4240-ae1b-a4a8306f9e20");
        //1.第一种情况：发送文本消息
       /* vo.setContent("我发送的消息是：文本消息");
        List<String> memberList = new ArrayList<>();
        memberList.add("TangHuiHong");
        memberList.add("@all");
        vo.setMemberList(memberList);
        vo.setMsgType("text");*/

        //2.第二种情况，发送图片消息
        vo.setMsgType("image");
        vo.setSavePath("F:\\1592442208192.png");

        //3.第三种情况，发送机器人消息
//        vo.setMsgType("news");
//        vo.setTitle("中秋节礼品领取");
//        vo.setDescription("今年中秋节公司有豪礼相送");
//        vo.setUrl("URL");
//        vo.setImageUrl("http://res.mail.qq.com/node/ww/wwopenmng/images/independent/doc/test_pic_msg1.png");
        wechatTemplateService.testSendNews(vo);

    }
}
