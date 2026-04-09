package com.example.bookingservice.integration.service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePnrClientRequest {

    private String userId;
    private String flightCode;
    private String seatNo;
    private Double price;

}
