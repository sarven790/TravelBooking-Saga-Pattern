package com.example.bookingservice.domain.temporal.activity.impl;

import com.example.bookingservice.domain.model.FlightPnrDto;
import com.example.bookingservice.domain.model.ReservationDto;
import com.example.bookingservice.domain.model.input.CreatePnrInput;
import com.example.bookingservice.domain.model.input.CreateReservationInput;
import com.example.bookingservice.domain.temporal.activity.BookingSagaActivities;
import com.example.bookingservice.integration.service.FlightPnrServiceClient;
import com.example.bookingservice.integration.service.HotelReservationClientService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookingSagaActivitiesImpl implements BookingSagaActivities {

    private final HotelReservationClientService hotelClientService;
    private final FlightPnrServiceClient flightClient;

    @Override
    public FlightPnrDto createPnr(CreatePnrInput input) {
        var response = flightClient.createPnr(input.getLanguage(),input.toRequest());
        return response.getData().toDto();
    }

    @Override
    public ReservationDto createReservation(CreateReservationInput input) {
        var response = hotelClientService.createReservation(input.getLanguage(), input.toRequest());
        return response.getData().toDto();
    }
}
