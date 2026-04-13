package com.example.bookingservice.integration.service;

import com.example.bookingservice.integration.config.FeignClientConfiguration;
import com.example.bookingservice.integration.service.dto.request.CancelReservationClientRequest;
import com.example.bookingservice.integration.service.dto.request.CreateReservationClientRequest;
import com.example.bookingservice.integration.service.dto.response.BaseClientResponse;
import com.example.bookingservice.integration.service.dto.response.CreateReservationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "${hotel-reservation-service-client.name}", url = "${hotel-reservation-service-client.url}",
        configuration = FeignClientConfiguration.class)
public interface HotelReservationClientService {

    @PostMapping(value = "${hotel-reservation-service-client.create-reservation}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    BaseClientResponse<CreateReservationResponse> createReservation(@RequestHeader("Accept-Language")String lang,
                                                                    CreateReservationClientRequest request);

    @PostMapping(value = "${hotel-reservation-service-client.cancel-reservation}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    BaseClientResponse<Void> cancelReservation(@RequestHeader("Accept-Language")String lang,
                                               CancelReservationClientRequest request);

}
