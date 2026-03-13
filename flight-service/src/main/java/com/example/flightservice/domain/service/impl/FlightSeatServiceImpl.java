package com.example.flightservice.domain.service.impl;

import com.example.flightservice.dao.entity.FlightSeat;
import com.example.flightservice.dao.repository.FlightSeatRepository;
import com.example.flightservice.domain.model.input.FlightSeatInput;
import com.example.flightservice.domain.model.output.FlightSeatOutput;
import com.example.flightservice.domain.service.FlightSeatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FlightSeatServiceImpl implements FlightSeatService {

    private final FlightSeatRepository flightSeatRepository;

    @Override
    public FlightSeatOutput saveFlightSeat(FlightSeatInput input) {
        var entity = FlightSeat.builder()
                .flight(input.getFlight())
                .seat(input.getSeat())
                .status(input.getSeatStatus())
                .price(input.getPrice())
                .holdUntil(input.getHoldUntil())
                .flightHoldId(input.getFlightHoldId())
                .heldBy(input.getHeldBy())
                .build();
        FlightSeat newFlightSeat = flightSeatRepository.save(entity);
        Boolean isExecuted = newFlightSeat.getId() != null ? Boolean.TRUE : Boolean.FALSE;
        return FlightSeatOutput.builder()
                .isExecuted(isExecuted)
                .build();
    }
}
