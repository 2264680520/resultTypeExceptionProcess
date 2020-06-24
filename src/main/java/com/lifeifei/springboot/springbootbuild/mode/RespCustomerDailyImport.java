package com.lifeifei.springboot.springbootbuild.mode;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.NumberFormat;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author:容合
 * @create:2020-06-15 14:
 * @description:
 */
@Data
@Builder
public class RespCustomerDailyImport {
    @ExcelProperty("客户编码")
    private String customerName;
    @ExcelProperty("MIS编码")
    private String misCode;
    @ExcelProperty("月度滚动额")
    private BigDecimal monthlyQuota;
    @ExcelProperty("最新应收账款余额")
    private BigDecimal accountReceivableQuota;
    @NumberFormat("#.##%")
    @ExcelProperty("本月利率(年化)")
    private BigDecimal dailyInterestRate;
}
