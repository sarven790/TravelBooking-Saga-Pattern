package com.example.flightservice.dao.repository.dto;

import com.example.flightservice.domain.model.enums.PnrStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PnrDto {
    private String flightHoldId;
    private Date holdExpiry;
    private PnrStatus pnrStatus;
}
