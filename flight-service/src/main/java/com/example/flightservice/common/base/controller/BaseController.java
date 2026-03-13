package com.example.flightservice.common.base.controller;

import com.example.flightservice.common.base.response.BaseResponse;
import com.example.flightservice.common.base.response.Error;
import com.example.flightservice.common.base.response.builer.BaseResponseBuilder;
import com.example.flightservice.common.exception.enums.BaseErrorType;
import com.example.flightservice.common.utils.MessageUtil;
import org.springframework.context.MessageSource;

public abstract class BaseController {

    protected <T> BaseResponse<T> responseSuccess(T data) {
        return BaseResponseBuilder.build(true,data);
    }

    protected BaseResponse<Void> responseSuccess(MessageSource messageSource,String messageCode) {
        var message = MessageUtil.getErrorMessageForCreate(messageSource,messageCode);
        return BaseResponseBuilder.build(true,message);
    }

    protected <T>BaseResponse<T> responseSuccess(String messageCode,MessageSource messageSource) {
        var message = MessageUtil.getErrorMessageForCreate(messageSource,messageCode);
        return BaseResponseBuilder.build(true,message);
    }

    protected BaseResponse<Void> responseFail(String messageCode, MessageSource messageSource, BaseErrorType errorType) {

        var errorDescription = MessageUtil.getErrorMessageForCreate(messageSource,messageCode);
        return BaseResponseBuilder.build(false,new Error(errorType,errorDescription));
    }

}
