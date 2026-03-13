package com.example.flightservice.domain.model.output;

import com.example.flightservice.api.dto.response.SeatListResponse;
import com.example.flightservice.dao.repository.dto.SeatDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SeatListOutput {
    private List<SeatDto> seatDtoList;

    public SeatListResponse toResponse() {
        return SeatListResponse.builder()
                .seatDtoList(seatDtoList)
                .build();
    }

}
