package com.example.flightservice.domain.model.input;

import com.example.flightservice.dao.entity.Flight;
import com.example.flightservice.dao.entity.Seat;
import com.example.flightservice.dao.enums.SeatStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightSeatInput {

    private Flight flight;
    private Seat seat;
    private SeatStatus seatStatus;
    private Double price;
    private Date holdUntil;
    private String heldBy;   // sessionId / userId
    private String bookedBy; // userId
    private String flightHoldId;
    private String hotelReservationId;

}
