package com.example.bookingservice.integration.service.util;

import feign.Response;
import org.springframework.util.StreamUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class DecoderUtil {

    public static String readBody(Response response) {
        if (response.body() != null) {
            try(InputStream bodyStream = response.body().asInputStream()) {
                return StreamUtils.copyToString(bodyStream, StandardCharsets.UTF_8);
            } catch (Exception exception) {
                throw new RuntimeException(exception.getMessage());
            }
        }
        return null;
    }

}
