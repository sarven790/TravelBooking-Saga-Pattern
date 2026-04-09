package com.example.bookingservice.integration.decoder;

import com.example.bookingservice.common.exception.ExternalException;
import com.example.bookingservice.integration.service.dto.response.ErrorResponse;
import com.example.bookingservice.integration.service.util.DecoderUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Request;
import feign.RequestTemplate;
import feign.Response;
import feign.Target;
import feign.codec.ErrorDecoder;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response){

        String responseBody = DecoderUtil.readBody(response);

        String serviceName = Optional.ofNullable(response)
                .map(Response::request)
                .map(Request::requestTemplate)
                .map(RequestTemplate::feignTarget)
                .map(Target::name).orElse(Strings.EMPTY);

        try {
            handleException(responseBody, serviceName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new Exception(response.reason());
    }

    private void handleException(String responseBody, String serviceName) throws ExternalException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        responseBody = responseBody.replace("\n", "");
        ErrorResponse errorResponse = mapper.readValue(responseBody, ErrorResponse.class);
        throw new ExternalException(errorResponse,serviceName);
    }

}
