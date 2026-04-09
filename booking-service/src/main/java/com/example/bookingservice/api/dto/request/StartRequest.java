package com.example.bookingservice.api.dto.request;

import com.example.bookingservice.domain.model.input.StartInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StartRequest {
    private Integer roomId;
    private String flightCode;
    private String seatNo;
    private Double price;

    public StartInput toInput() {
        return StartInput.builder()
                .roomId(roomId)
                .flightCode(flightCode)
                .seatNo(seatNo)
                .price(price)
                .build();
    }

}
