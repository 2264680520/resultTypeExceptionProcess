package com.lifeifei.springboot.springbootbuild.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.lifeifei.springboot.springbootbuild.mapper.AreaWeatherMapper;
import com.lifeifei.springboot.springbootbuild.mode.AreaWeather;
import com.lifeifei.springboot.springbootbuild.mode.RespCustomerDailyImport;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:容合
 * @create:2020-06-16 14:
 * @description:
 */
@RestController
@Slf4j
public class ExportContorller {

    @Autowired
    private AreaWeatherMapper areaWeatherMapper;

    @GetMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        // ArrayList<Object> respCustomerDailyImports = new ArrayList<>();
        List<AreaWeather> areaWeathers = areaWeatherMapper.getAreaWeatherList();
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("导出", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), AreaWeather.class)
                .sheet("sheet0")
                // 设置字段宽度为自动调整，不太精确
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .doWrite(areaWeathers);
    }

    @PostMapping("/import")
    public void importFile(@RequestParam MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        List<AreaWeather> areaWeathers = EasyExcel.read(inputStream)
                .head(AreaWeather.class)
                // 设置sheet,默认读取第一个
                .sheet()
                // 设置标题所在行数
                .headRowNumber(1)
                .doReadSync();
        log.info("123");
    }
}
