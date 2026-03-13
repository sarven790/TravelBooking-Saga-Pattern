package com.example.flightservice.domain.model.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlightSeatOutput {
    private Boolean isExecuted;
}
