package com.example.bookingservice.integration.service.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String errorStatus;
    private String errorDescription;
}
