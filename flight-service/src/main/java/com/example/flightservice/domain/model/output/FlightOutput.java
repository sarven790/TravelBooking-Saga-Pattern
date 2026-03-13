package com.example.flightservice.domain.model.output;

import com.example.flightservice.dao.entity.Flight;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlightOutput {

    private Flight flight;

}
