package com.example.bookingservice.domain.model.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RunInput {
    private String userId;
    private Integer roomId;
    private String flightCode;
    private String seatNo;
    private Double price;
    private String bookingId;
    private String workflowId;
    private String language;

}
