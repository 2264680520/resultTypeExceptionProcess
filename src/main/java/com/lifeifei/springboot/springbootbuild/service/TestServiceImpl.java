package com.lifeifei.springboot.springbootbuild.service;

import com.lifeifei.springboot.springbootbuild.exptions.BizException;
import com.lifeifei.springboot.springbootbuild.mapper.AreaWeatherMapper;
import com.lifeifei.springboot.springbootbuild.mode.enums.ResultEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService, InitializingBean {

    private String string;


    @Override
    public Object testException(String s) {
        String[] split = s.split(",");
        if(split.length==1){
            throw new BizException(ResultEnum.NON_SPLIT);
        }
        return split[2];
    }

    @Override
    public String string() {
        return string;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        string = "测试string";
    }
}
