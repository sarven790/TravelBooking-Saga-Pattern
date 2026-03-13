package com.example.flightservice.api.dto.request;

import com.example.flightservice.domain.model.input.AircraftInput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AircraftRequest {

    private String brandName;
    private String modelNo;
    private List<String> seats;

    public AircraftInput toInput() {
        return AircraftInput.builder()
                .brandName(brandName)
                .modelNo(modelNo)
                .seats(seats)
                .build();
    }

}
