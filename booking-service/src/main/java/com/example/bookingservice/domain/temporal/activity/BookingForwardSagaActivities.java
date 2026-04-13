package com.example.bookingservice.domain.temporal.activity;

import com.example.bookingservice.domain.model.FlightPnrDto;
import com.example.bookingservice.domain.model.ReservationDto;
import com.example.bookingservice.domain.model.input.CreatePnrInput;
import com.example.bookingservice.domain.model.input.CreateReservationInput;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface BookingForwardSagaActivities {

    @ActivityMethod
    FlightPnrDto createPnr(CreatePnrInput input);
    @ActivityMethod
    ReservationDto createReservation(CreateReservationInput input);

}
