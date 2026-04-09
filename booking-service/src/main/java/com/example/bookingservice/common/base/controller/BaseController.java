package com.example.bookingservice.common.base.controller;

import com.example.bookingservice.common.base.response.BaseResponse;
import com.example.bookingservice.common.base.response.Error;
import com.example.bookingservice.common.base.response.builer.BaseResponseBuilder;
import com.example.bookingservice.common.exception.enums.BaseErrorType;
import com.example.bookingservice.common.utils.MessageUtil;
import org.springframework.context.MessageSource;

public abstract class BaseController {

    protected <T> BaseResponse<T> responseSuccess(T data) {
        return BaseResponseBuilder.build(true,data);
    }

    protected BaseResponse<Void> responseSuccess(String message) {
        return BaseResponseBuilder.build(true,message);
    }

    protected BaseResponse<Void> responseFail(String messageCode, MessageSource messageSource, BaseErrorType errorType) {

        var errorDescription = MessageUtil.getErrorMessageForCreate(messageSource,messageCode);
        return BaseResponseBuilder.build(false,new Error(errorType,errorDescription));
    }

    protected BaseResponse<Void> responseFail(String errorDescription, BaseErrorType errorType) {
        return BaseResponseBuilder.build(false,new Error(errorType,errorDescription));
    }

}
