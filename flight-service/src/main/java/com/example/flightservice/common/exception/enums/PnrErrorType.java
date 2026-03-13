package com.example.flightservice.common.exception.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PnrErrorType implements BaseErrorType{

    FAILED_FLIGHT_HOLD("app.flight_hold_error"),
    FAILED_FLIGHT_CONFIRM("app.flight_confirm_error"),
    FAILED_FLIGHT_UNEXPECTED_EXCEPTION("app.flight_unhandled_error");

    private final String code;

    @Override
    public String getCode() {
        return code;
    }
}
