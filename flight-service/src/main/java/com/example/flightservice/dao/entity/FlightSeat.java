package com.example.flightservice.dao.entity;

import com.example.flightservice.common.base.entity.BaseEntity;
import com.example.flightservice.dao.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "flight_seat",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_flight_seat", columnNames = {"flight_id", "seat_id"})
        },
        schema = "flightservice"
)
public class FlightSeat extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "flight_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_flight_seat_flight")
    )
    private Flight flight;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "seat_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_flight_seat_seat")
    )
    private Seat seat;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatStatus status; // AVAILABLE/HOLD/BOOKED

    // Uçuşa göre fiyat: class + kampanya + dinamik fiyat vs.
    @Column(nullable = false)
    private Double price;

    // Hold işini doğru yapmak için:
    private Date holdUntil;

    // Basitçe kim hold etti / kim aldı (opsiyonel)
    private String heldBy;   // sessionId / userId
    private String bookedBy; // userId
    private String flightHoldId;
    private String hotelReservationId;

}
