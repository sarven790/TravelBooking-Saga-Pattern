package com.example.bookingservice.integration.service;

import com.example.bookingservice.integration.config.FeignClientConfiguration;
import com.example.bookingservice.integration.service.dto.request.CancelPnrClientRequest;
import com.example.bookingservice.integration.service.dto.request.CreatePnrClientRequest;
import com.example.bookingservice.integration.service.dto.response.BaseClientResponse;
import com.example.bookingservice.integration.service.dto.response.CreatePnrClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "${flight-pnr-service-client.name}", url = "${flight-pnr-service-client.url}",
        configuration = FeignClientConfiguration.class)
public interface FlightPnrServiceClient {

    @PostMapping(value = "${flight-pnr-service-client.create-pnr}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    BaseClientResponse<CreatePnrClientResponse> createPnr(@RequestHeader("Accept-Language")String lang,
                                                          CreatePnrClientRequest request);

    @PostMapping(value = "${flight-pnr-service-client.cancel-pnr}")
    BaseClientResponse<Void> cancelPnr(@RequestHeader("Accept-Language")String lang,
                                       CancelPnrClientRequest request);

}
