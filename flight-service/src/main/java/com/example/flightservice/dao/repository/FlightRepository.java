package com.example.flightservice.dao.repository;

import com.example.flightservice.dao.entity.Flight;
import com.example.flightservice.dao.repository.dto.FlightRow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,String> {

    @Query("select f.id from Flight f where f.flightCode =:flightCode")
    String getFlightIdByCode(@RequestParam("flightCode") String flightCode);

    @Query("""
select new com.example.flightservice.dao.repository.dto.FlightRow(
  f.flightCode,f.departurePoint, f.arrivePoint, f.departureDate, f.arriveDate, f.basePrice,
  a.brandName, a.modelNo
)
from Flight f
join f.aircraft a
where f.departurePoint = :departurePoint
  and f.arrivePoint = :arrivePoint
  and f.departureDate = :departureDate
  and f.arriveDate = :arriveDate
""")
    List<FlightRow> findFlightRows(
            @Param("departurePoint") String departurePoint,
            @Param("arrivePoint") String arrivePoint,
            @Param("departureDate") Date departureDate,
            @Param("arriveDate") Date arriveDate
    );

}
