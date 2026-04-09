package com.example.bookingservice.common.base.response.builer;


import com.example.bookingservice.common.base.response.BaseResponse;
import com.example.bookingservice.common.base.response.Error;

public class BaseResponseBuilder {

    public static <T>BaseResponse<T> build(boolean isSuccess, T data) {
        return new BaseResponse<T>(isSuccess,data);
    }

    public static <T>BaseResponse<T> build(boolean isSuccess, String message) {
        return new BaseResponse<>(isSuccess,message);
    }

    public static <T>BaseResponse<T> build(boolean isSuccess, Error error) {
        return new BaseResponse<>(isSuccess,error);
    }

}
