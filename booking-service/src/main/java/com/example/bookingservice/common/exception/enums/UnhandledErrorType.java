package com.example.bookingservice.common.exception.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum UnhandledErrorType implements BaseErrorType{
    UNHANDLED_ERROR_TYPE("app.booking_unhandled_error");

    private final String code;

    @Override
    public String getCode() {
        return code;
    }
}
