package com.example.flightservice.domain.service.impl;

import com.example.flightservice.common.exception.BusinessException;
import com.example.flightservice.common.exception.enums.PnrErrorType;
import com.example.flightservice.domain.model.enums.PnrStatus;
import com.example.flightservice.dao.entity.Flight;
import com.example.flightservice.dao.entity.Seat;
import com.example.flightservice.dao.enums.SeatStatus;
import com.example.flightservice.domain.model.input.*;
import com.example.flightservice.domain.model.output.CreatePnrOutput;
import com.example.flightservice.domain.model.output.FlightSeatOutput;
import com.example.flightservice.domain.service.FlightSeatService;
import com.example.flightservice.domain.service.FlightService;
import com.example.flightservice.domain.service.PnrService;
import com.example.flightservice.domain.service.SeatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class PnrServiceImpl implements PnrService {

    private final SeatService seatService;
    private final FlightService flightService;
    private final FlightSeatService flightSeatService;

    @Override
    public CreatePnrOutput createPnr(CreatePnrInput input) {

        //generate flightHoldId
        String flightHoldId = UUID.randomUUID().toString();
        Date holdUntil = Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));

        // 1. seat => seatService
        var seat = getSeatByNo(input.getSeatNo());

        // 2.  flightIdRef => flightService
        var flight = getFlightByCode(input.getFlightCode());

        // 3.  save => flightSeatService
        Boolean isExecuted = saveFlightService(input,flight,seat,flightHoldId,holdUntil);

        if (!isExecuted) {
            throw new BusinessException(PnrErrorType.FAILED_FLIGHT_HOLD);
        }

        //4. update Seat status
        updateSeatStatus(seat,SeatStatus.HOLD);

        return CreatePnrOutput.builder()
                .pnrStatus(PnrStatus.FLIGHT_HELD)
                .flightHoldId(flightHoldId)
                .holdExpiry(holdUntil)
                .build();

    }

    private Boolean saveFlightService(CreatePnrInput input,
                                      Flight flight,
                                      Seat seat,
                                      String flightHoldId,
                                      Date holdUntil) {
        FlightSeatOutput flightSeatOutput = flightSeatService.saveFlightSeat(FlightSeatInput.builder()
                .flight(flight)
                .seat(seat)
                .flightHoldId(flightHoldId)
                .holdUntil(holdUntil)
                .seatStatus(SeatStatus.HOLD)
                .heldBy(input.getUserId())
                .price(input.getPrice())
                .build());
        return flightSeatOutput.getIsExecuted();
    }

    @Override
    public void cancelPnr(CancelPnrInput input) {
        flightSeatService.changeFlightSeatStatus(ChangeFlightSeatStatusInput.builder()
                .flightHoldId(input.getFlightHoldId())
                .build());
    }

    private Seat getSeatByNo(String no) {
        return seatService.getSeatByNo(SeatInput.builder()
                .no(no)
                .build()).getSeat();
    }

    private Flight getFlightByCode(String flightCode) {
        return flightService.getFlightByCode(GetFlightByCodeInput.builder()
                .flightCode(flightCode)
                .build()).getFlight();
    }

    private void updateSeatStatus(Seat seat,SeatStatus seatStatus) {
        seatService.updateSeatStatus(SeatUpdateInput.builder()
                .seatStatus(seatStatus)
                .seat(seat)
                .build());
    }

}
