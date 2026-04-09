package com.example.bookingservice.common.interceptor;

import com.example.bookingservice.common.base.controller.BaseController;
import com.example.bookingservice.common.base.response.BaseResponse;
import com.example.bookingservice.common.base.response.Error;
import com.example.bookingservice.common.exception.BusinessException;
import com.example.bookingservice.common.exception.ExternalException;
import com.example.bookingservice.common.exception.enums.ExternalErrorType;
import com.example.bookingservice.common.exception.enums.UnhandledErrorType;
import com.example.bookingservice.integration.service.dto.response.ErrorResponse;
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
    public BaseResponse<Void> handleException(Exception e) {
        log.error("An error is occurrence {}",e.getMessage());
        return responseFail(UnhandledErrorType.UNHANDLED_ERROR_TYPE.getCode(), messageSource,UnhandledErrorType.UNHANDLED_ERROR_TYPE);
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

    @ExceptionHandler(value = ExternalException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse<Void> handleExternalException(ExternalException e) {
        log.error("ExternalException occurred: " + e.getMessage() + " ServiceName: " + e.getServiceName().trim() + " ErrorStatus: " + e.getError().getErrorStatus(), e);
        if (e.getError().getErrorDescription() != null) {
            return responseFail(e.getError().getErrorDescription(), ExternalErrorType.EXTERNAL_ERROR_TYPE);
        }
        return responseFail(ExternalErrorType.EXTERNAL_ERROR_TYPE.getCode(), messageSource,ExternalErrorType.EXTERNAL_ERROR_TYPE);
    }

}
