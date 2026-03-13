package com.example.flightservice.domain.model;

import com.example.flightservice.dao.repository.dto.AircraftDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightDto {

    private String flightCode;
    private String departurePoint;
    private String arrivePoint;

    private Date departureDate;
    private Date arriveDate;

    private Double basePrice;
    private AircraftDto aircraft;


}
