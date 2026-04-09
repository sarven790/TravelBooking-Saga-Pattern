package com.example.bookingservice.domain.temporal.activity;

import com.example.bookingservice.domain.model.FlightPnrDto;
import com.example.bookingservice.domain.model.ReservationDto;
import com.example.bookingservice.domain.model.input.CreatePnrInput;
import com.example.bookingservice.domain.model.input.CreateReservationInput;
import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface BookingSagaActivities {

    FlightPnrDto createPnr(CreatePnrInput input);
    ReservationDto createReservation(CreateReservationInput input);

}
