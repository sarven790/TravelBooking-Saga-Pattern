package com.example.flightservice.api.controller;

import com.example.flightservice.api.dto.request.CancelPnrRequest;
import com.example.flightservice.api.dto.request.CreatePnrRequest;
import com.example.flightservice.api.dto.response.CreatePnrResponse;
import com.example.flightservice.common.base.controller.BaseController;
import com.example.flightservice.common.base.response.BaseResponse;
import com.example.flightservice.domain.service.PnrService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/pnr")
@RequiredArgsConstructor
public class PnrController extends BaseController {

    private final PnrService pnrService;
    private final MessageSource messageSource;

    //create pnr
    @PostMapping("/create-pnr")
    public BaseResponse<CreatePnrResponse> createPnr(@RequestBody CreatePnrRequest request) {
        var output = pnrService.createPnr(request.toInput());
        return responseSuccess(output.toResponse());
    }

    //check-pnr


    //cancel-pnr
    @PostMapping("/cancel-pnr")
    public BaseResponse<Void> cancelPnr(@RequestBody CancelPnrRequest request) {
        pnrService.cancelPnr(request.toInput());
        return responseSuccess("",messageSource);
    }

}
