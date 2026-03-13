package com.example.flightservice.api.controller;

import com.example.flightservice.api.dto.request.SeatListRequest;
import com.example.flightservice.api.dto.response.SeatListResponse;
import com.example.flightservice.common.base.controller.BaseController;
import com.example.flightservice.common.base.response.BaseResponse;
import com.example.flightservice.domain.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/seat")
@RequiredArgsConstructor
public class SeatController extends BaseController {

    private final SeatService seatService;

    @PostMapping("/seat-list")
    public BaseResponse<SeatListResponse> seatList(@RequestBody SeatListRequest request) {
        var output = seatService.seatList(request.toInput());
        return responseSuccess(output.toResponse());
    }

}
