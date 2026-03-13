package com.example.flightservice.api.dto.response;

import com.example.flightservice.dao.repository.dto.SeatDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SeatListResponse {
    private List<SeatDto> seatDtoList;
}
