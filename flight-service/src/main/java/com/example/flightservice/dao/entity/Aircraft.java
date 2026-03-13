package com.example.flightservice.dao.entity;

import com.example.flightservice.common.base.entity.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "aircraft", schema = "flightservice")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Aircraft extends BaseEntity {

    private String brandName;
    private String modelNo;

    @OneToMany(mappedBy = "aircraft", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Seat> seats = new ArrayList<>();

    @OneToMany(mappedBy = "aircraft")
    @Builder.Default
    private List<Flight> flights = new ArrayList<>();

    // ✅ İlişkiyi iki tarafta da kur
    public void addSeat(Seat seat) {
        seats.add(seat);
        seat.setAircraft(this);
    }

    public void removeSeat(Seat seat) {
        seats.remove(seat);
        seat.setAircraft(null);
    }

    public void setSeats(List<Seat> newSeats) {
        // orphanRemoval için güvenli set
        this.seats.clear();
        if (newSeats != null) {
            newSeats.forEach(this::addSeat);
        }
    }
}