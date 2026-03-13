package com.example.flightservice.common.interceptor;

import com.example.flightservice.common.base.controller.BaseController;
import com.example.flightservice.common.base.response.BaseResponse;
import com.example.flightservice.common.exception.BusinessException;
import com.example.flightservice.common.exception.enums.UnhandledErrorType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class ResponseExceptionHandler extends BaseController {

    private final MessageSource messageSource;

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse<Void> handleExceptionHandle(Exception e) {
        String messageCode= UnhandledErrorType.UNHANDLED_ERROR_TYPE.getCode();
        log.error("UnhandledError occurred: " + messageCode);
        return responseFail(messageCode,messageSource,UnhandledErrorType.UNHANDLED_ERROR_TYPE);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse<Void> handleValidationExceptionHandler(MethodArgumentNotValidException e) {
        Optional<FieldError> fieldError = Optional.ofNullable(e.getFieldError());
        String errorCode = fieldError.map(error -> Optional.ofNullable(error.getDefaultMessage()).get())
                .orElseGet(UnhandledErrorType.UNHANDLED_ERROR_TYPE::getCode);
        log.error("MethodArgumentNotValidException occurred: " + errorCode);
        return responseFail(errorCode,messageSource,UnhandledErrorType.UNHANDLED_ERROR_TYPE);
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<Void> handleBusinessExceptionHandle(BusinessException e) {
        String messageCode= e.getErrorType().getCode();
        log.error("BusinessException occurred: {}",messageCode);
        return responseFail(messageCode,messageSource, e.getErrorType());
    }

}
