package com.example.bookingservice.domain.model.input;

import com.example.bookingservice.integration.service.dto.request.CreatePnrClientRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePnrInput {

    private String userId;
    private String flightCode;
    private String seatNo;
    private Double price;
    private String language;

    public CreatePnrClientRequest toRequest(){
        return CreatePnrClientRequest.builder()
                .userId(userId)
                .flightCode(flightCode)
                .seatNo(seatNo)
                .price(price)
                .build();
    }

}
