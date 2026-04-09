package com.example.bookingservice.domain.service.impl;

import com.example.bookingservice.common.helper.RequestScopeHelper;
import com.example.bookingservice.common.scope.RequestHeaderScope;
import com.example.bookingservice.domain.model.input.StartInput;
import com.example.bookingservice.domain.service.OrchestratorService;
import com.example.bookingservice.domain.temporal.workflow.BookingSagaWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrchestratorServiceImpl implements OrchestratorService {

    private final WorkflowClient workflowClient;
    private final RequestHeaderScope requestHeaderScope;

    @Value("${temporal.task-queue}")
    private String taskQueue;

    @Override
    public void start(StartInput input) {

        String bookingId = UUID.randomUUID().toString();
        String workflowId = "Booking - " + bookingId;
        String userId = RequestScopeHelper.userId(requestHeaderScope);
        String lang = RequestScopeHelper.language(requestHeaderScope);

        BookingSagaWorkflow workflow = workflowClient.newWorkflowStub(
                BookingSagaWorkflow.class,
                WorkflowOptions.newBuilder()
                        .setWorkflowId(workflowId)
                        .setTaskQueue(taskQueue)
                        .build()
        );

        var runInput = input.toInput(userId, workflowId, bookingId, lang);

        WorkflowClient.start(workflow::run, runInput);

    }
}
