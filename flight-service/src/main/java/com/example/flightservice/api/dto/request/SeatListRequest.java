package com.example.flightservice.api.dto.request;

import com.example.flightservice.domain.model.input.SeatListInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeatListRequest {
    private String aircraftBrandName;
    private String aircraftModelNo;

    public SeatListInput toInput() {
        return SeatListInput.builder()
                .aircraftBrandName(aircraftBrandName)
                .aircraftModelNo(aircraftModelNo)
                .build();
    }

}
