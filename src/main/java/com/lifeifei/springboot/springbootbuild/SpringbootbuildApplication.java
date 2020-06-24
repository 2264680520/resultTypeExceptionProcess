package com.lifeifei.springboot.springbootbuild;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.lifeifei.springboot.springbootbuild.mapper")//使用MapperScan批量扫描所有的Mapper接口；
@SpringBootApplication
public class SpringbootbuildApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootbuildApplication.class, args);
    }

}
