package com.example.flightservice.domain.mapper;

import com.example.flightservice.dao.repository.dto.AircraftDto;
import com.example.flightservice.domain.model.FlightDto;
import com.example.flightservice.dao.repository.dto.FlightRow;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class FlightDtoMapper {

    public static List<FlightDto> toDtoList(List<FlightRow> flightRows) {
        return flightRows.stream()
                .map(r -> FlightDto.builder()
                        .flightCode(r.flightCode())
                        .departurePoint(r.departurePoint())
                        .arrivePoint(r.arrivePoint())
                        .departureDate(r.departureDate())
                        .arriveDate(r.arriveDate())
                        .basePrice(r.basePrice())
                        .aircraft(AircraftDto.builder()
                                .brandName(r.brandName())
                                .modelNo(r.modelNo())
                                .build())
                        .build())
                .toList();
    }

}
