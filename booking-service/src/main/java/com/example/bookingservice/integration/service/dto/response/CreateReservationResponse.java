package com.example.bookingservice.integration.service.dto.response;

import com.example.bookingservice.domain.model.ReservationDto;
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
public class CreateReservationResponse {
    private String hotelHoldId;
    private LocalDateTime holdExpiry;
    private Status reservationStatus;

    public ReservationDto toDto() {
        return ReservationDto.builder()
                .hotelHoldId(hotelHoldId)
                .holdExpiry(holdExpiry)
                .reservationStatus(reservationStatus)
                .build();
    }

}
