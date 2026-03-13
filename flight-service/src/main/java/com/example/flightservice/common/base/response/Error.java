package com.example.flightservice.common.base.response;

import com.example.flightservice.common.exception.enums.BaseErrorType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Error {
    private BaseErrorType errorStatus;
    private String errorDescription;
}
