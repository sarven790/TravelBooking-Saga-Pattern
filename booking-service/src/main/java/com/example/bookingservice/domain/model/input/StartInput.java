package com.example.bookingservice.domain.model.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StartInput {
    private Integer roomId;
    private String flightCode;
    private String seatNo;
    private Double price;

    public RunInput toInput(String userId, String workflowId,String bookingId, String language) {
        return RunInput.builder()
                .userId(userId)
                .workflowId(workflowId)
                .bookingId(bookingId)
                .roomId(roomId)
                .flightCode(flightCode)
                .seatNo(seatNo)
                .price(price)
                .language(language)
                .build();
    }

}
