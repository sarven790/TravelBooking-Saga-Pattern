package com.example.bookingservice.domain.temporal.activity;

import com.example.bookingservice.domain.model.input.CancelPnrInput;
import com.example.bookingservice.domain.model.input.CancelReservationInput;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface BookingCompensationSagaActivities {

    @ActivityMethod
    void cancelPnr(CancelPnrInput input);

    @ActivityMethod
    void cancelHotelReservation(CancelReservationInput input);

}
