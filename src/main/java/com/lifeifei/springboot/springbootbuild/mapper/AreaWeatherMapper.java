package com.lifeifei.springboot.springbootbuild.mapper;

import com.lifeifei.springboot.springbootbuild.mode.AreaWeather;

import java.util.List;

public interface AreaWeatherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AreaWeather record);

    int insertSelective(AreaWeather record);

    AreaWeather selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AreaWeather record);

    int updateByPrimaryKey(AreaWeather record);

    List<AreaWeather> getAreaWeatherList();
}