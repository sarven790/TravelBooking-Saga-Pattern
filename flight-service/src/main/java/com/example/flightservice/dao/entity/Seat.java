package com.example.flightservice.dao.entity;

import com.example.flightservice.common.base.entity.BaseEntity;
import com.example.flightservice.dao.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "seat", schema = "flightservice")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Seat extends BaseEntity {

    private String no; // "1A", "12C"

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private SeatStatus status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "aircraft_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_seat_aircraft")
    )
    private Aircraft aircraft;
}
