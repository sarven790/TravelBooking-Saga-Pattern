package com.example.bookingservice.domain.service.impl;

import com.example.bookingservice.dao.entity.Booking;
import com.example.bookingservice.dao.repository.BookingRepository;
import com.example.bookingservice.domain.model.enums.State;
import com.example.bookingservice.domain.model.enums.Status;
import com.example.bookingservice.domain.model.input.InitInput;
import com.example.bookingservice.domain.model.input.UpdateStatusInput;
import com.example.bookingservice.domain.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Override
    public void init(InitInput input) {
        Booking booking = Booking.builder()
                .bookingId(input.getBookingId())
                .workflowId(input.getWorkflowId())
                .customerId(input.getCustomerId())
                .status(Status.START.name())
                .currentStep(State.INIT.name())
                .build();

        bookingRepository.save(booking);

    }

    @Override
    public void updateStatus(UpdateStatusInput input) {


        var entity = bookingRepository.findAllByBookingIdEqualsIgnoreCase(input.getBookingId())
                .orElse(new Booking());

        if (input.getState().equals(State.FLIGHT_CREATE_PNR)) {
            var pnrDto = input.getFlightPnrDto();
            entity = Booking.builder()
                    .flightHoldId(pnrDto.getFlightHoldId())
                    .flightStatus(pnrDto.getPnrStatus().name())
                    .status(input.getStatus().name())
                    .currentStep(input.getState().name())
                    .build();
        }

        bookingRepository.save(entity);
    }

    @Override
    public void markFailed(String bookingId, String errorCode, String errorMessage) {

    }
}
