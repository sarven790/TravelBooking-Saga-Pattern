package com.example.bookingservice.domain.temporal.activity.impl;

import com.example.bookingservice.common.exception.ExternalException;
import com.example.bookingservice.domain.model.FlightPnrDto;
import com.example.bookingservice.domain.model.ReservationDto;
import com.example.bookingservice.domain.model.input.CreatePnrInput;
import com.example.bookingservice.domain.model.input.CreateReservationInput;
import com.example.bookingservice.domain.temporal.activity.BookingForwardSagaActivities;
import com.example.bookingservice.integration.service.FlightPnrServiceClient;
import com.example.bookingservice.integration.service.HotelReservationClientService;
import io.temporal.failure.ApplicationFailure;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookingForwardSagaActivitiesImpl implements BookingForwardSagaActivities {

    private final HotelReservationClientService hotelClientService;
    private final FlightPnrServiceClient flightClient;

    @Override
    public FlightPnrDto createPnr(CreatePnrInput input) {
        try {
            var response = flightClient.createPnr(input.getLanguage(), input.toRequest());
            return response.getData().toDto();
        } catch (ExternalException e) {
            throw ApplicationFailure.newNonRetryableFailure(
                    e.getMessage(),
                    ExternalException.class.getName(),
                    e.getError());
        }
    }

    @Override
    public ReservationDto createReservation(CreateReservationInput input) {
        try {
            var response = hotelClientService.createReservation(input.getLanguage(), input.toRequest());
            return response.getData().toDto();
        } catch (ExternalException e) {
            throw ApplicationFailure.newNonRetryableFailure(
                    e.getMessage(),
                    ExternalException.class.getName(),
                    e.getError());
        }
    }
}
