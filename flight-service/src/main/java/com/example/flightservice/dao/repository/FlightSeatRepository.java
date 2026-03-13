package com.example.flightservice.dao.repository;

import com.example.flightservice.dao.entity.FlightSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightSeatRepository extends JpaRepository<FlightSeat,String> {

}
