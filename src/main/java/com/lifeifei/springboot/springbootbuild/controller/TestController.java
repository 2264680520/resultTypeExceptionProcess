package com.lifeifei.springboot.springbootbuild.controller;

import com.lifeifei.springboot.springbootbuild.exptions.BizException;
import com.lifeifei.springboot.springbootbuild.mode.enums.ResultEnum;
import com.lifeifei.springboot.springbootbuild.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/initializingBean")
    @ResponseBody
    public String initializingBean(String name) {
        return testService.string();
    }

    @GetMapping("/")
    @ResponseBody
    public String index(String name) {
        return name;
    }

    @GetMapping("/object")
    @ResponseBody
    public Map<String, Object> object(String name, String addr) {
        Map<String, Object> map = new HashMap<>();
        map.put(name, name);
        if (addr.equals("error")) {
            throw new BizException(ResultEnum.ADDRESS_ERROR);
        } else if (addr.equals("error2")) {
            throw new RuntimeException("未知异常");
        } else if (addr.equals("error3")) {
            String[] arr = new String[]{"1", "2"};
            System.out.println(arr[3]);
        }
        testService.testException(addr);
        return map;
    }
}
