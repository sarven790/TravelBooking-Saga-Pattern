package com.example.flightservice.api.controller;

import com.example.flightservice.api.dto.request.AircraftRequest;
import com.example.flightservice.common.base.controller.BaseController;
import com.example.flightservice.common.base.response.BaseResponse;
import com.example.flightservice.domain.service.AircraftService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/aircraft")
@RequiredArgsConstructor
public class AircraftController extends BaseController {

    private final AircraftService aircraftService;
    private final MessageSource messageSource;

    @PostMapping("/add-aircraft")
    public BaseResponse<Void> addAircraft(@RequestBody AircraftRequest request) {
        aircraftService.addAircraft(request.toInput());
        return responseSuccess(messageSource,"");
    }

}
