package com.example.bookingservice.integration.service.dto.response;

import com.example.bookingservice.domain.model.FlightPnrDto;
import com.example.bookingservice.domain.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreatePnrClientResponse {

    private String flightHoldId;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm", timezone = "Europe/Istanbul")
    private Date holdExpiry;

    private Status pnrStatus;

    public FlightPnrDto toDto() {
        return FlightPnrDto.builder()
                .flightHoldId(flightHoldId)
                .holdExpiry(holdExpiry)
                .pnrStatus(pnrStatus)
                .build();
    }

}
