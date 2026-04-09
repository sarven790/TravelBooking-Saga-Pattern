package com.example.bookingservice.common.helper;

import com.example.bookingservice.common.scope.RequestHeader;
import com.example.bookingservice.common.scope.RequestHeaderScope;

import java.util.Optional;

public class RequestScopeHelper {

    public static String userId(RequestHeaderScope requestHeaderScope) {
        RequestHeader requestHeader = requestHeaderScope.getRequestHeader();
        return Optional.ofNullable(requestHeader.getUserId()).orElse("");
    }

    public static String language(RequestHeaderScope requestHeaderScope) {
        RequestHeader requestHeader = requestHeaderScope.getRequestHeader();
        return Optional.ofNullable(requestHeader.getLanguage()).orElse("tr-TR");
    }

}
