package com.example.bookingservice.domain.temporal.activity.impl;

import com.example.bookingservice.domain.model.input.InitInput;
import com.example.bookingservice.domain.model.input.UpdateStatusInput;
import com.example.bookingservice.domain.service.BookingService;
import com.example.bookingservice.domain.temporal.activity.SagaStateActivities;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SagaStateActivitiesImpl implements SagaStateActivities {

    private final BookingService bookingService;

    @Override
    public void initializeSaga(InitInput input) {
        bookingService.init(input);
    }

    @Override
    public void updateStatus(UpdateStatusInput input) {
        bookingService.updateStatus(input);
    }

    @Override
    public void markFailed(String bookingId, String errorCode, String errorMessage) {
        bookingService.markFailed(bookingId,errorCode,errorMessage);
    }
}
