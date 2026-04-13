package com.example.flightservice.api.dto.request;

import com.example.flightservice.domain.model.input.CancelPnrInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CancelPnrRequest {
    private String flightHoldId;

    public CancelPnrInput toInput() {
        return CancelPnrInput.builder()
                .flightHoldId(flightHoldId)
                .build();
    }

}
