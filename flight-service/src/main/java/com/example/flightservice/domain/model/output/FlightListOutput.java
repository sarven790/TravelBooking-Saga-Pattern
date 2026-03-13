package com.example.flightservice.domain.model.output;

import com.example.flightservice.api.dto.response.FlightListResponse;
import com.example.flightservice.domain.model.FlightDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FlightListOutput {

    private List<FlightDto> flightDtoList;

    public FlightListResponse toResponse() {
        return FlightListResponse.builder()
                .flightDtoList(flightDtoList)
                .build();
    }

}
