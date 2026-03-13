package com.example.flightservice.api.dto.response;

import com.example.flightservice.domain.model.FlightDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FlightListResponse {

    private List<FlightDto> flightDtoList;

}
