package com.example.bookingservice.domain.temporal.workflow.impl;


import com.example.bookingservice.common.exception.ExternalException;
import com.example.bookingservice.domain.model.enums.State;
import com.example.bookingservice.domain.model.enums.Status;
import com.example.bookingservice.domain.model.input.*;
import com.example.bookingservice.domain.temporal.activity.BookingCompensationSagaActivities;
import com.example.bookingservice.domain.temporal.activity.BookingForwardSagaActivities;
import com.example.bookingservice.domain.temporal.activity.SagaStateActivities;
import com.example.bookingservice.domain.temporal.util.WorkflowUtil;
import com.example.bookingservice.domain.temporal.workflow.BookingSagaWorkflow;
import com.example.bookingservice.integration.service.dto.response.ErrorResponse;
import io.temporal.failure.ActivityFailure;
import io.temporal.failure.ApplicationFailure;
import io.temporal.workflow.Workflow;
import org.slf4j.Logger;

import java.time.Duration;

public class BookingSagaWorkflowImpl implements BookingSagaWorkflow {

    private final Logger log = Workflow.getLogger(BookingSagaWorkflowImpl.class);

   private final BookingForwardSagaActivities forwardSagaActivities = WorkflowUtil.bookingSagaForwardActivitiesInstance(
            Duration.ofSeconds(10),
            Duration.ofSeconds(1),
            2.0,
            Duration.ofSeconds(5), 3);

   private final BookingCompensationSagaActivities compensationSagaActivities = WorkflowUtil.bookingCompensationSagaActivities(
           Duration.ofSeconds(10),
           Duration.ofSeconds(1),
           2.0,
           Duration.ofSeconds(5), 3);

    private final SagaStateActivities sagaStateActivities = WorkflowUtil.sagaStateActivitiesInstance(
            Duration.ofSeconds(5), 3);

    @Override
    public void run(RunInput input) {
        String userId = input.getUserId();
        String bookingId = input.getBookingId();
        String workflowId = input.getWorkflowId();

        boolean reservationCreated = Boolean.FALSE;
        boolean pnrCreated = Boolean.FALSE;

        try {
            sagaStateActivities.initializeSaga(InitInput.builder()
                    .customerId(userId)
                    .bookingId(bookingId)
                    .workflowId(workflowId)
                    .build());

            log.info("Booking workflow started. workflowId={}", input.getWorkflowId());

            var hotelOutput = forwardSagaActivities.createReservation(CreateReservationInput.builder()
                            .roomId(input.getRoomId())
                            .userId(userId)
                            .language(input.getLanguage())
                    .build());
            reservationCreated = Boolean.TRUE;

            sagaStateActivities.updateStatus(UpdateStatusInput.builder()
                    .bookingId(bookingId)
                    .status(hotelOutput.getReservationStatus())
                    .state(State.HOTEL_CREATE_RESERVATION)
                    .reservationDto(hotelOutput)
                    .build());

            var flightOutput = forwardSagaActivities.createPnr(CreatePnrInput.builder()
                            .userId(userId)
                            .flightCode(input.getFlightCode())
                            .seatNo(input.getSeatNo())
                            .price(input.getPrice())
                            .language(input.getLanguage())
                    .build());
            pnrCreated = Boolean.TRUE;

            sagaStateActivities.updateStatus(UpdateStatusInput.builder()
                    .bookingId(bookingId)
                    .status(flightOutput.getPnrStatus())
                    .state(State.FLIGHT_CREATE_PNR)
                    .flightPnrDto(flightOutput)
                    .build());

        } catch (ActivityFailure e) {
            log.error("Workflow failed. bookingId={}, error={}", bookingId, e.getMessage());

            if (e.getCause() instanceof ApplicationFailure applicationFailure
            && ExternalException.class.getName().equals(applicationFailure.getType())) {

                var booking = sagaStateActivities.getBookingByBookingId(bookingId);

                ErrorResponse errorResponse = applicationFailure.getDetails().get(ErrorResponse.class);
                sagaStateActivities.markFailed(bookingId,
                        errorResponse.getErrorStatus(), errorResponse.getErrorDescription());

                if (Boolean.TRUE.equals(reservationCreated)) {
                    compensationSagaActivities.cancelHotelReservation(CancelReservationInput.builder()
                            .hotelHoldId(booking.getHotelHoldId())
                            .language(input.getLanguage())
                            .build());
                }

                if (Boolean.TRUE.equals(pnrCreated)) {
                    compensationSagaActivities.cancelPnr(CancelPnrInput.builder()
                            .flightHoldId(booking.getFlightHoldId())
                            .language(input.getLanguage())
                            .build());
                }

            }

            throw e;

        }

    }
}
