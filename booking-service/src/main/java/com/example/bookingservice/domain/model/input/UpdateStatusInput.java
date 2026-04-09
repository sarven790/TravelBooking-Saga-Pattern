package com.example.bookingservice.domain.model.input;

import com.example.bookingservice.domain.model.FlightPnrDto;
import com.example.bookingservice.domain.model.ReservationDto;
import com.example.bookingservice.domain.model.enums.State;
import com.example.bookingservice.domain.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateStatusInput {
    private String bookingId;
    private Status status;
    private State state; // todo: state'e göre dolacak alanlar belirlenecek. burası için ayrıca case çalışılmalı!
    private FlightPnrDto flightPnrDto;
    private ReservationDto reservationDto;

}
