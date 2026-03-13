package com.example.flightservice.domain.model.input;

import com.example.flightservice.dao.entity.Seat;
import com.example.flightservice.dao.enums.SeatStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeatUpdateInput {
    private Seat seat;
    private SeatStatus seatStatus;
}
