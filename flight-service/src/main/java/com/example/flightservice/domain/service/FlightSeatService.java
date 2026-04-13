package com.example.flightservice.domain.service;

import com.example.flightservice.domain.model.input.ChangeFlightSeatStatusInput;
import com.example.flightservice.domain.model.input.FlightSeatInput;
import com.example.flightservice.domain.model.output.FlightSeatOutput;

public interface FlightSeatService {

    FlightSeatOutput saveFlightSeat(FlightSeatInput input);

    void changeFlightSeatStatus(ChangeFlightSeatStatusInput input);

}
