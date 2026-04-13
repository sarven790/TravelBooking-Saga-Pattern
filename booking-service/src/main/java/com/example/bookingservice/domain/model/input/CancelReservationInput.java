package com.example.bookingservice.domain.model.input;

import com.example.bookingservice.integration.service.dto.request.CancelReservationClientRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CancelReservationInput {
    private String hotelHoldId;
    private String language;

    public CancelReservationClientRequest toRequest() {
        return CancelReservationClientRequest.builder()
                .hotelHoldId(hotelHoldId)
                .build();
    }

}
