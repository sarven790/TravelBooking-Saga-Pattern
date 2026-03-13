package com.example.flightservice.domain.model.output;

import com.example.flightservice.dao.entity.Seat;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SeatOutput {
    private Seat seat;
}
