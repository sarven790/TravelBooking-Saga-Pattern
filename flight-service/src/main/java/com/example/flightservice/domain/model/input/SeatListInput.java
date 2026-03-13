package com.example.flightservice.domain.model.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeatListInput {
    private String aircraftBrandName;
    private String aircraftModelNo;
}
