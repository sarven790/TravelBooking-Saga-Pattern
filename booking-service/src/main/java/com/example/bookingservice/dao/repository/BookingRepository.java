package com.example.bookingservice.dao.repository;

import com.example.bookingservice.dao.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking,String> {

    Optional<Booking> findAllByBookingIdEqualsIgnoreCase(String bookingId);

}
