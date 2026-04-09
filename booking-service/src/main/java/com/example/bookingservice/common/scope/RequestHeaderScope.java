package com.example.bookingservice.common.scope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class RequestHeaderScope {

    private RequestHeader requestHeader;

    public RequestHeader getRequestHeader(){
        return requestHeader;
    }

    public void setRequestHeader(RequestHeader requestHeader){
        this.requestHeader = requestHeader;
    }

}
