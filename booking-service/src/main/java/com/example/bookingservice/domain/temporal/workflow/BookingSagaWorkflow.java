package com.example.bookingservice.domain.temporal.workflow;

import com.example.bookingservice.domain.model.input.RunInput;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface BookingSagaWorkflow {

    @WorkflowMethod
    void run(RunInput input);

}
