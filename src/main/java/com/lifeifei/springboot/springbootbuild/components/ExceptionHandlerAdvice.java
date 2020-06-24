package com.lifeifei.springboot.springbootbuild.components;

import com.lifeifei.springboot.springbootbuild.exptions.BizException;
import com.lifeifei.springboot.springbootbuild.mode.Result;
import com.lifeifei.springboot.springbootbuild.mode.enums.ResultType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<Object> restError(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        Result<Object> result = new Result<>();
        if (ex instanceof BizException) {
            BizException e = (BizException) ex;
            result.setCode(e.getCode());
            result.setMsg(e.getMsg());
            result.setStatus(ResultType.FAIL.name());
        }else{
            result.setCode(-1);
            result.setMsg(ex.toString());
            result.setStatus(ResultType.FAIL.name());
            System.out.println(ex.toString());
            ex.printStackTrace();
        }
        return result;
    }
}
