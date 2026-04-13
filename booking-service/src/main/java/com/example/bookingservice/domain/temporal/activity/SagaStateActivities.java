package com.example.bookingservice.domain.temporal.activity;

import com.example.bookingservice.dao.entity.Booking;
import com.example.bookingservice.domain.model.input.InitInput;
import com.example.bookingservice.domain.model.input.UpdateStatusInput;
import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface SagaStateActivities {

    void initializeSaga(InitInput input);
    void updateStatus(UpdateStatusInput input);
    void markFailed(String bookingId, String errorCode, String errorMessage);

    Booking getBookingByBookingId(String bookingId);

}
