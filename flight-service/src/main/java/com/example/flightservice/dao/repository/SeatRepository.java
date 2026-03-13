package com.example.flightservice.dao.repository;

import com.example.flightservice.dao.entity.Aircraft;
import com.example.flightservice.dao.entity.Seat;
import com.example.flightservice.dao.enums.SeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface SeatRepository extends JpaRepository<Seat,String> {

    @Query("select s.id from Seat s where s.no =:no and s.status = 'AVAILABLE'")
    String getSeatByNoAndStatusIsAvailable(@Param("no") String no);

    List<Seat> findAllByAircraft_Id(String id);

}
