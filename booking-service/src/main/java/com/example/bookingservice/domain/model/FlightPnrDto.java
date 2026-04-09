package com.example.bookingservice.domain.model;

import com.example.bookingservice.domain.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FlightPnrDto {

    private String flightHoldId;
    private Date holdExpiry;
    private Status pnrStatus;
}
