package com.example.flightservice.common.exception.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum UnhandledErrorType implements BaseErrorType{
    UNHANDLED_ERROR_TYPE("app.flight_unhandled_error");

    private final String code;

    @Override
    public String getCode() {
        return code;
    }
}
