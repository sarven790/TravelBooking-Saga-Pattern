package com.example.flightservice.dao.entity;

import com.example.flightservice.common.base.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "flight", schema = "flightservice")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Flight extends BaseEntity {

    private String flightCode;
    private String departurePoint;
    private String arrivePoint;

    private Date departureDate;
    private Date arriveDate;

    private Double basePrice;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "aircraft_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_flight_aircraft")
    )
    private Aircraft aircraft;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FlightSeat> flightSeats = new ArrayList<>();
}
