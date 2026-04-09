package com.example.bookingservice.domain.model;

import com.example.bookingservice.domain.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    private String hotelHoldId;
    private LocalDateTime holdExpiry;
    private Status reservationStatus;

}
