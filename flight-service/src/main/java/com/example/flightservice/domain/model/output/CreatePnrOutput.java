package com.example.flightservice.domain.model.output;

import com.example.flightservice.api.dto.response.CreatePnrResponse;
import com.example.flightservice.domain.model.enums.PnrStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreatePnrOutput {

    private String flightHoldId;
    private Date holdExpiry;
    private PnrStatus pnrStatus;

    public CreatePnrResponse toResponse() {
        return CreatePnrResponse.builder()
                .flightHoldId(flightHoldId)
                .holdExpiry(holdExpiry)
                .pnrStatus(pnrStatus)
                .build();
    }

}
