package com.example.bookingservice.common.scope;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestHeader {
    private String userId;
    private String language;
}
