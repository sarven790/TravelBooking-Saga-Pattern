package com.example.bookingservice.domain.model.input;

import com.example.bookingservice.domain.model.enums.Status;
import com.example.bookingservice.integration.service.dto.request.CancelPnrClientRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CancelPnrInput {
    private String language;
    private String flightHoldId;

    public CancelPnrClientRequest toRequest() {
        return CancelPnrClientRequest.builder()
                .flightHoldId(flightHoldId)
                .build();
    }

}
