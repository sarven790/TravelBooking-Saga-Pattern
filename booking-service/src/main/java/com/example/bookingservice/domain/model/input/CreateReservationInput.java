package com.example.bookingservice.domain.model.input;

import com.example.bookingservice.integration.service.dto.request.CreateReservationClientRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateReservationInput {

    private String userId;
    private Integer roomId;
    private String language;

    public CreateReservationClientRequest toRequest(){
        return CreateReservationClientRequest.builder()
                .userId(userId)
                .roomId(roomId)
                .build();
    }

}
