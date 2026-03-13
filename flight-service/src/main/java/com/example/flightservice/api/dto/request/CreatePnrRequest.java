package com.example.flightservice.api.dto.request;

import com.example.flightservice.domain.model.input.CreatePnrInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePnrRequest {

    private String userId;
    private String flightCode;
    private String seatNo;
    private Double price;

    public CreatePnrInput toInput() {
        return CreatePnrInput.builder()
                .userId(userId)
                .flightCode(flightCode)
                .seatNo(seatNo)
                .price(price)
                .build();
    }

}
