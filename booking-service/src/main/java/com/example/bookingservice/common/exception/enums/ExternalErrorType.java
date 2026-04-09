package com.example.bookingservice.common.exception.enums;

public enum ExternalErrorType implements BaseErrorType{

    EXTERNAL_ERROR_TYPE("app.booking_unhandled_error");

    private String code;

    ExternalErrorType(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }

}
