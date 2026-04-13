package com.example.flightservice.domain.service;

import com.example.flightservice.domain.model.input.CancelPnrInput;
import com.example.flightservice.domain.model.input.CreatePnrInput;
import com.example.flightservice.domain.model.output.CreatePnrOutput;

public interface PnrService {

    CreatePnrOutput createPnr(CreatePnrInput input);
    void cancelPnr(CancelPnrInput input);

}
