package com.example.flightservice.domain.model.input;

import com.example.flightservice.dao.entity.Aircraft;
import com.example.flightservice.dao.entity.Flight;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightInput {

    private String departurePoint;
    private String arrivePoint;
    private Date departureDate;
    private Date arriveDate;
    private Double basePrice;
    private String aircraftName;

    public Flight toEntity(Aircraft aircraft) {
        return Flight.builder()
                .flightCode(UUID.randomUUID().toString())
                .departurePoint(departurePoint)
                .arrivePoint(arrivePoint)
                .departureDate(departureDate)
                .arriveDate(arriveDate)
                .basePrice(basePrice)
                .aircraft(aircraft)
                .build();
    }

}
