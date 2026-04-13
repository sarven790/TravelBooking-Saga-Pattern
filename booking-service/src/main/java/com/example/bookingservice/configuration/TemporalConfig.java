package com.example.bookingservice.configuration;

import com.example.bookingservice.domain.service.BookingService;
import com.example.bookingservice.domain.temporal.activity.BookingCompensationSagaActivities;
import com.example.bookingservice.domain.temporal.activity.BookingForwardSagaActivities;
import com.example.bookingservice.domain.temporal.activity.SagaStateActivities;
import com.example.bookingservice.domain.temporal.activity.impl.BookingCompensationSagaActivitiesImpl;
import com.example.bookingservice.domain.temporal.activity.impl.BookingForwardSagaActivitiesImpl;
import com.example.bookingservice.domain.temporal.activity.impl.SagaStateActivitiesImpl;
import com.example.bookingservice.domain.temporal.workflow.impl.BookingSagaWorkflowImpl;
import com.example.bookingservice.integration.service.FlightPnrServiceClient;
import com.example.bookingservice.integration.service.HotelReservationClientService;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowClientOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import io.temporal.worker.WorkerFactoryOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class TemporalConfig implements DisposableBean {

    private WorkerFactory factory;

    @Bean
    public WorkflowServiceStubs workflowServiceStubs(@Value("${temporal.target}") String target) {
        return WorkflowServiceStubs.newServiceStubs(
                WorkflowServiceStubsOptions.newBuilder()
                        .setTarget(target)
                        .build()
        );
    }

    @Bean
    public WorkflowClient workflowClient(WorkflowServiceStubs service,
                                         @Value("${temporal.namespace}") String namespace) {
        return WorkflowClient.newInstance(
                service,
                WorkflowClientOptions.newBuilder()
                        .setNamespace(namespace)
                        .build()
        );
    }

    @Bean
    public BookingForwardSagaActivities bookingForwardSagaActivities(HotelReservationClientService hotelClient,
                                                              FlightPnrServiceClient flightPnrClient) {
        return new BookingForwardSagaActivitiesImpl(
                hotelClient,
                flightPnrClient
        );
    }

    @Bean
    public BookingCompensationSagaActivities bookingCompensationSagaActivities(HotelReservationClientService hotelClient,
                                                                   FlightPnrServiceClient flightPnrClient) {
        return new BookingCompensationSagaActivitiesImpl(
                hotelClient,
                flightPnrClient
        );
    }

    @Bean
    public SagaStateActivities sagaStateActivities(BookingService bookingService) {
        return new SagaStateActivitiesImpl(bookingService);
    }

    @Bean
    public WorkerFactory workerFactory(WorkflowClient client,
                                       BookingForwardSagaActivities bookingForwardSagaActivities,
                                       SagaStateActivities sagaStateActivities,
                                       BookingCompensationSagaActivities bookingCompensationSagaActivities,
                                       @Value("${temporal.task-queue}") String taskQueue) {

        this.factory = WorkerFactory.newInstance(
                client,
                WorkerFactoryOptions.newBuilder().build()
        );

        Worker worker = factory.newWorker(taskQueue);

        worker.registerWorkflowImplementationTypes(BookingSagaWorkflowImpl.class);

        worker.registerActivitiesImplementations(
                bookingForwardSagaActivities,
                sagaStateActivities,
                bookingCompensationSagaActivities
        );

        factory.start();
        log.info("Temporal worker started. taskQueue={}", taskQueue);

        return factory;
    }

    @Override
    public void destroy() {
        if (factory != null) {
            factory.shutdown();
            log.info("Temporal worker factory shutdown completed.");
        }
    }
}