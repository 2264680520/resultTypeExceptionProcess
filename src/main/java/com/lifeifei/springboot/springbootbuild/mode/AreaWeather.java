package com.lifeifei.springboot.springbootbuild.mode;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class AreaWeather {

    @ExcelProperty("记录ID")
    private Integer id;


    @ExcelProperty("省份名")
    private String province;


    @ExcelProperty("城市名")
    private String city;


    @ExcelProperty("区域编码")
    private String adcode;


    @ExcelProperty("天气现象")
    private String weather;


    @ExcelProperty("实时气温")
    private String temperature;


    @ExcelProperty("风向描述")
    private String winddirection;


    @ExcelProperty("风力级别")
    private String windpower;


    @ExcelProperty("空气湿度")
    private String humidity;


    @ExcelProperty("发布时间")
    private Date reporttime;


    @ExcelProperty("插入时间")
    private Date createTime;

}