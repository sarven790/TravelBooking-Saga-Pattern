package com.example.flightservice.api.dto.response;

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
public class CreatePnrResponse {

    private String flightHoldId;
    private Date holdExpiry;
    private PnrStatus pnrStatus;

}
