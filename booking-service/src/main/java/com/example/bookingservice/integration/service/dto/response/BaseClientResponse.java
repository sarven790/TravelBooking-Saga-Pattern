package com.example.bookingservice.integration.service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BaseClientResponse<T> {
    private boolean isSuccess;
    private T data;
    private String executionDate;
    private String message;
    private ErrorResponse error;
}
