package com.example.flightservice.domain.model.input;

import com.example.flightservice.dao.enums.SeatStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChangeFlightSeatStatusInput {
    private String flightHoldId;
    private SeatStatus seatStatus;
}
