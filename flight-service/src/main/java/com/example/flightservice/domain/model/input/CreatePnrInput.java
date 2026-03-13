package com.example.flightservice.domain.model.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePnrInput {

    private String userId;
    private String flightCode;
    private String seatNo;
    private Double price;


}
