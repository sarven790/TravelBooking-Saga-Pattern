package com.example.bookingservice.common.exception;

import com.example.bookingservice.common.base.response.Error;
import com.example.bookingservice.integration.service.dto.response.ErrorResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Getter
@RequiredArgsConstructor
public class ExternalException extends RuntimeException implements Serializable {

    @Serial
    private static final long serialVersionUID = -7123456789012345678L;

    private ErrorResponse error;
    private String serviceName;

    public ExternalException(ErrorResponse error, String serviceName) {
        this.error = error;
        this.serviceName = serviceName;
    }

}
