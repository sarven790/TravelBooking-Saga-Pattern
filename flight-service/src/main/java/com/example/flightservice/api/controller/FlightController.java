package com.example.flightservice.api.controller;

import com.example.flightservice.api.dto.request.FlightRequest;
import com.example.flightservice.api.dto.request.GetFlightListRequestByRotation;
import com.example.flightservice.api.dto.response.FlightListResponse;
import com.example.flightservice.common.base.controller.BaseController;
import com.example.flightservice.common.base.response.BaseResponse;
import com.example.flightservice.domain.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/flight")
@RequiredArgsConstructor
public class FlightController extends BaseController {

    private final FlightService flightService;
    private final MessageSource messageSource;

    @PostMapping("/add-flight")
    public BaseResponse<Void> addFlight(@RequestBody FlightRequest request) {
        flightService.addFlight(request.toInput());
        return responseSuccess(messageSource,"");
    }

    @PostMapping("/flight-list")
    public BaseResponse<FlightListResponse> flightList(@RequestBody GetFlightListRequestByRotation request) {
        var output = flightService.flightList(request.toInput());
        return responseSuccess(output.toResponse());
    }

}
