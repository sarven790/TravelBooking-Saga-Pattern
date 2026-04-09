package com.example.bookingservice.integration.interceptor;

import com.example.bookingservice.common.exception.ExternalException;
import com.example.bookingservice.integration.service.dto.response.BaseClientResponse;
import com.example.bookingservice.integration.service.dto.response.ErrorResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.StreamUtils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Slf4j
public class FeignClientInterceptor extends Client.Default{

    public FeignClientInterceptor(SSLSocketFactory sslContextFactory, HostnameVerifier hostnameVerifier) {
        super(sslContextFactory,hostnameVerifier);
    }

    @Override
    public Response execute(Request request, Request.Options options) throws IOException {
        String responseBody = "";
        try(Response response = super.execute(request,options)) {
            if (response.body() != null) {

                String serviceName = Optional.ofNullable(response)
                        .map(Response::request)
                        .map(Request::requestTemplate)
                        .map(RequestTemplate::feignTarget)
                        .map(Target::name).orElse(Strings.EMPTY);

                InputStream bodyStream = response.body().asInputStream();
                responseBody = StreamUtils.copyToString(bodyStream, StandardCharsets.UTF_8);
                checkResponseBody(responseBody,request,serviceName);
            }
            return response.toBuilder().body(responseBody, StandardCharsets.UTF_8).build();
        }
    }

    private void checkResponseBody(String responseBody, Request request, String serviceName) {
        try {

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseBody);

            JsonNode isSuccessNode = root.get("isSuccess");
            JsonNode errorNode = root.get("error");

            boolean successFalse = isSuccessNode == null
                    || isSuccessNode.isNull() || isSuccessNode.booleanValue();

            boolean hasError =
                    errorNode != null &&
                            !errorNode.isNull();

            if (!successFalse || hasError) {
                ErrorResponse errorResponse = mapper.treeToValue(errorNode,ErrorResponse.class);
                throw new ExternalException(errorResponse,serviceName);
            }

        } catch (IOException e) {
            log.warn("Response body JSON parse edilemedi. url={}, response={}, error={}",
                    request.url(), responseBody, e.getMessage());
            throw new RuntimeException();
        }
    }

}
