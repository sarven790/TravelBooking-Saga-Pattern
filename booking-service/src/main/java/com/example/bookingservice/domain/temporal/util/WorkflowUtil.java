package com.example.bookingservice.domain.temporal.util;

import com.example.bookingservice.domain.temporal.activity.BookingSagaActivities;
import com.example.bookingservice.domain.temporal.activity.SagaStateActivities;
import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class WorkflowUtil {

    public static BookingSagaActivities bookingSagaActivitiesInstance(Duration startToCloseTimeout,
                                                                      Duration initialInternal,
                                                                      Double backoffCoefficient,
                                                                      Duration maximumInternal,
                                                                      Integer maximumAttempts) {
        return Workflow.newActivityStub(
                BookingSagaActivities.class,
                ActivityOptions.newBuilder()
                        .setStartToCloseTimeout(startToCloseTimeout)
                        .setRetryOptions(
                                RetryOptions.newBuilder()
                                        .setInitialInterval(initialInternal)
                                        .setBackoffCoefficient(backoffCoefficient)
                                        .setMaximumInterval(maximumInternal)
                                        .setMaximumAttempts(maximumAttempts)
                                        .build()
                        )
                        .build()
        );
    }

    public static SagaStateActivities sagaStateActivitiesInstance(Duration startToCloseTimeout, Integer maximumAttempts) {
        return Workflow.newActivityStub(
                SagaStateActivities.class,
                ActivityOptions.newBuilder()
                        .setStartToCloseTimeout(startToCloseTimeout)
                        .setRetryOptions(
                                RetryOptions.newBuilder()
                                        .setMaximumAttempts(maximumAttempts)
                                        .build()
                        )
                        .build()
        );
    }

}
