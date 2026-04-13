package com.example.bookingservice.domain.temporal.activity.impl;

import com.example.bookingservice.domain.model.input.CancelPnrInput;
import com.example.bookingservice.domain.model.input.CancelReservationInput;
import com.example.bookingservice.domain.temporal.activity.BookingCompensationSagaActivities;
import com.example.bookingservice.integration.service.FlightPnrServiceClient;
import com.example.bookingservice.integration.service.HotelReservationClientService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookingCompensationSagaActivitiesImpl implements BookingCompensationSagaActivities {

    private final HotelReservationClientService hotelClientService;
    private final FlightPnrServiceClient flightClient;

    @Override
    public void cancelPnr(CancelPnrInput input) {
        flightClient.cancelPnr(input.getLanguage(),input.toRequest());
    }

    @Override
    public void cancelHotelReservation(CancelReservationInput input) {
        hotelClientService.cancelReservation(input.getLanguage(),input.toRequest());
    }
}
