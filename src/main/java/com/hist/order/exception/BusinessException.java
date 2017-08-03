package com.hist.order.exception;

import com.hist.order.config.ErrorCodeConfig;

/******************************************
 * @author: wangyuan
 * @createDate: 2017/8/3
 * @company: (C) Copyright 
 * @since: JDK 1.8
 * @Description:
 ******************************************/
public class BusinessException extends RuntimeException {
    private String code;
    private String content;

    public BusinessException(String code) {
        super(ErrorCodeConfig.getErrorMsg(code));
        this.code = code;
    }

    public BusinessException(String code, String content) {
        super(content);
        this.code = code;
        this.content = content;
    }

    public BusinessException(String code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

