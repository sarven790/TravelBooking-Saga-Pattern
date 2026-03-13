package com.example.flightservice.domain.model.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetFlightListInputByRotation {
    private String departurePoint;
    private String arrivePoint;
    private Date departureDate;
    private Date arriveDate;


}
