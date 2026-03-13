package com.example.flightservice.api.dto.request;

import com.example.flightservice.domain.model.input.GetFlightListInputByRotation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetFlightListRequestByRotation {
    private String departurePoint;
    private String arrivePoint;
    private Date departureDate;
    private Date arriveDate;

    public GetFlightListInputByRotation toInput() {
        return GetFlightListInputByRotation.builder()
                .departurePoint(departurePoint)
                .arrivePoint(arrivePoint)
                .departureDate(departureDate)
                .arriveDate(arriveDate)
                .build();
    }

}
