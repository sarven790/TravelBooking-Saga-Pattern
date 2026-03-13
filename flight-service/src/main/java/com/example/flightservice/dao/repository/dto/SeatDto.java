package com.example.flightservice.dao.repository.dto;

import com.example.flightservice.dao.enums.SeatStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeatDto {

    private String no;
    private SeatStatus status;


}
