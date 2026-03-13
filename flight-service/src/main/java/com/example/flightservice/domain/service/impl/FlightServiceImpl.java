package com.example.flightservice.domain.service.impl;

import com.example.flightservice.common.exception.BusinessException;
import com.example.flightservice.common.exception.enums.FlightErrorType;
import com.example.flightservice.dao.entity.Flight;
import com.example.flightservice.dao.repository.FlightRepository;
import com.example.flightservice.domain.mapper.FlightDtoMapper;
import com.example.flightservice.domain.model.input.AircraftInputByName;
import com.example.flightservice.domain.model.input.FlightInput;
import com.example.flightservice.domain.model.input.GetFlightByCodeInput;
import com.example.flightservice.domain.model.input.GetFlightListInputByRotation;
import com.example.flightservice.domain.model.output.FlightListOutput;
import com.example.flightservice.domain.model.output.FlightOutput;
import com.example.flightservice.domain.service.FlightService;
import com.example.flightservice.domain.util.AircraftUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final AircraftUtil aircraftUtil;

    @Override
    public void addFlight(FlightInput input) {

        var aircraft = aircraftUtil.findByAircraftByBrandAndModel(AircraftInputByName
                .builder()
                .airName(input.getAircraftName())
                .build());
        if (Objects.isNull(aircraft)) {
            throw new BusinessException(FlightErrorType.AIRCRAFT_NOT_FOUND);
        }

        Flight flight = input.toEntity(aircraft);
        flightRepository.save(flight);

    }

    @Override
    public FlightListOutput flightList(GetFlightListInputByRotation input) {
        var flightRowList = flightRepository.findFlightRows(input.getDeparturePoint(),
                input.getArrivePoint(),input.getDepartureDate(),input.getArriveDate());

        return FlightListOutput.builder()
                .flightDtoList(FlightDtoMapper.toDtoList(flightRowList))
                .build();
    }

    @Override
    public FlightOutput getFlightByCode(GetFlightByCodeInput input) {

        String id = flightRepository.getFlightIdByCode(input.getFlightCode());
        Flight flight = flightRepository.getReferenceById(id);

        return FlightOutput.builder()
                .flight(flight)
                .build();

    }
}
