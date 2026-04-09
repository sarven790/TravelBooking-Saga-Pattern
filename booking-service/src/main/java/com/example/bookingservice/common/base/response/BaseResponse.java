package com.example.bookingservice.common.base.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BaseResponse<T> {

    private boolean isSuccess;
    private T data;
    private String executionDate;
    private String message;
    private Error error;

    private BaseResponse() {}

    public BaseResponse(boolean isSuccess, T data) {
        this.isSuccess = isSuccess;
        this.data = data;
        this.executionDate = ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public BaseResponse(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.executionDate = ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public BaseResponse(boolean isSuccess, Error error) {
        this.isSuccess = isSuccess;
        this.error = error;
        this.executionDate = ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

}
