package com.hist.order.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.hist.order.bean.JsonResult;
import com.hist.order.config.ErrorCodeConfig;
import com.hist.order.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/******************************************
 * @author: wangyuan
 * @createDate: 2017/8/3
 * @company: (C) Copyright 
 * @since: JDK 1.8
 * @Description:
 ******************************************/
public class BaseController {

    private Logger logger = LoggerFactory.getLogger(BaseController.class);
    private String errors;

    public BaseController() {
    }

    public void handleException(Exception ex, JsonResult result) {
        if(ex instanceof BusinessException) {
            BusinessException e = (BusinessException)ex;
            if(ErrorCodeConfig.hasErrorCode(e.getCode())) {
                result.setCode(e.getCode());
                if(StringUtils.isNotBlank(e.getContent())) {
                    result.setMsg(e.getContent());
                }
            } else {
                result.setCode(e.getCode());
                result.setMsg(e.getContent());
            }
        } else {
            if(!(ex instanceof JsonParseException) && !(ex instanceof IOException)) {
                if(ex instanceof NullPointerException) {
                    result.setCode("ERR_SYSTEM_NULLPOINT");
                } else {
                    result.setCode("ERR_SYSTEM");
                }
            } else {
                result.setCode("ERR_SYSTEM_JSON");
            }

            result.setMsg(ex.getMessage());
        }

        this.logger.error(ex.getMessage(), ex);
    }

    public JsonResult createSuccessResult() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode("OK");
        return jsonResult;
    }

    public String getErrors() {
        return this.errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }
}