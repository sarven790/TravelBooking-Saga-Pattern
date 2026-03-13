package com.example.flightservice.common.exception;

import com.example.flightservice.common.exception.enums.BaseErrorType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Getter
@RequiredArgsConstructor
public class BusinessException extends RuntimeException implements Serializable {

    @Serial
    private static final long serialVersionUID = -7123456789012345678L;

    private final BaseErrorType errorType;

}
