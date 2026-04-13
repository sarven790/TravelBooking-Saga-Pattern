package com.example.flightservice.dao.repository;

import com.example.flightservice.dao.entity.FlightSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightSeatRepository extends JpaRepository<FlightSeat,String> {
    Optional<FlightSeat> findAllByFlightHoldIdEqualsIgnoreCase(String flightHoldId);
}
