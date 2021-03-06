package com.lifeifei.springboot.springbootbuild.exptions;


import com.lifeifei.springboot.springbootbuild.mode.enums.ResultEnum;

public class BizException extends RuntimeException {
    private Integer code;
    private String msg;

    public BizException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.msg = resultEnum.getMsg();
        this.code = resultEnum.getCode();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
