package com.example.flightservice.domain.service;

import com.example.flightservice.domain.model.input.FlightInput;
import com.example.flightservice.domain.model.input.GetFlightByCodeInput;
import com.example.flightservice.domain.model.input.GetFlightListInputByRotation;
import com.example.flightservice.domain.model.output.FlightListOutput;
import com.example.flightservice.domain.model.output.FlightOutput;

public interface FlightService {
    void addFlight(FlightInput input);
    FlightListOutput flightList(GetFlightListInputByRotation input);
    FlightOutput getFlightByCode(GetFlightByCodeInput input);

}
