package com.example.flightservice.domain.service.impl;

import com.example.flightservice.dao.entity.Aircraft;
import com.example.flightservice.dao.repository.AircraftRepository;
import com.example.flightservice.domain.model.input.AircraftInput;
import com.example.flightservice.domain.model.input.AircraftInputByName;
import com.example.flightservice.domain.service.AircraftService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class AircraftServiceImpl implements AircraftService {

    private final AircraftRepository aircraftRepository;

    @Override
    public void addAircraft(AircraftInput input) {
        Aircraft aircraft = input.toEntity();
        aircraftRepository.save(aircraft);
    }

}
