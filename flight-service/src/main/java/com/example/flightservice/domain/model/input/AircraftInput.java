package com.example.flightservice.domain.model.input;

import com.example.flightservice.dao.entity.Aircraft;
import com.example.flightservice.dao.entity.Seat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AircraftInput {

    private String brandName;
    private String modelNo;
    private List<String> seats;

    public Aircraft toEntity() {
        var aircraft = Aircraft.builder()
                .brandName(brandName)
                .modelNo(modelNo)
                .build();

        List<Seat> seatEntities = seats.stream()
                .map(no -> {
                    Seat seat = new Seat();
                    seat.setNo(no);
                    seat.setAircraft(aircraft);
                    return seat;
                })
                .toList();

        aircraft.setSeats(seatEntities);
        return aircraft;
    }


}
