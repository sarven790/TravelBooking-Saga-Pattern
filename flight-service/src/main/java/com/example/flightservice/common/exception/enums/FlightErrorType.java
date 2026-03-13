package com.example.flightservice.common.exception.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum FlightErrorType implements BaseErrorType{

    AIRCRAFT_NOT_FOUND("");

    private final String code;

    @Override
    public String getCode() {
        return code;
    }
}
