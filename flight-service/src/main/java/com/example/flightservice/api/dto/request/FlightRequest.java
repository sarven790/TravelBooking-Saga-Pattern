package com.example.flightservice.api.dto.request;

import com.example.flightservice.domain.model.input.FlightInput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightRequest {

    private String departurePoint;
    private String arrivePoint;
    private Date departureDate;
    private Date arriveDate;
    private Double basePrice;
    private String aircraftName;

    public FlightInput toInput() {
        return FlightInput.builder()
                .departurePoint(departurePoint)
                .arrivePoint(arrivePoint)
                .departureDate(departureDate)
                .arriveDate(arriveDate)
                .basePrice(basePrice)
                .aircraftName(aircraftName)
                .build();
    }

}
