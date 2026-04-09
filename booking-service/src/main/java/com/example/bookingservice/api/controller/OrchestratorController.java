package com.example.bookingservice.api.controller;

import com.example.bookingservice.api.dto.request.StartRequest;
import com.example.bookingservice.api.dto.response.StartResponse;
import com.example.bookingservice.common.base.controller.BaseController;
import com.example.bookingservice.common.base.response.BaseResponse;
import com.example.bookingservice.domain.service.OrchestratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking/v1/orchestrator")
public class OrchestratorController extends BaseController {

    private final OrchestratorService orchestratorService;

    @PostMapping("/start")
    public BaseResponse<Void> start(@RequestBody StartRequest request) {
        orchestratorService.start(request.toInput());
        return responseSuccess(""); // todo: güncellenecek
    }

}
