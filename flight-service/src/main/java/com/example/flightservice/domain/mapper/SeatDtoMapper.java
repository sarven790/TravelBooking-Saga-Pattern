package com.example.flightservice.domain.mapper;

import com.example.flightservice.dao.entity.Seat;
import com.example.flightservice.dao.repository.dto.SeatDto;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class SeatDtoMapper {

    public static List<SeatDto> toDtoList(List<Seat> seatList) {
        return seatList.stream()
                .map(s -> SeatDto.builder()
                        .no(s.getNo())
                        .status(s.getStatus())
                        .build())
                .toList();
    }

}
