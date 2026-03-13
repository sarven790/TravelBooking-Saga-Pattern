package com.example.flightservice.dao.repository.dto;

import java.util.Date;

public record FlightRow(
        String flightCode,
        String departurePoint,
        String arrivePoint,
        Date departureDate,
        Date arriveDate,
        Double basePrice,
        String brandName,
        String modelNo
) {}
