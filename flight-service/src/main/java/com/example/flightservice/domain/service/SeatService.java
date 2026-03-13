package com.example.flightservice.domain.service;

import com.example.flightservice.domain.model.input.SeatInput;
import com.example.flightservice.domain.model.input.SeatListInput;
import com.example.flightservice.domain.model.input.SeatUpdateInput;
import com.example.flightservice.domain.model.output.SeatListOutput;
import com.example.flightservice.domain.model.output.SeatOutput;

public interface SeatService {

    void addSeat(SeatInput input);

    SeatOutput getSeatByNo(SeatInput input);

    SeatListOutput seatList(SeatListInput input);

    void updateSeatStatus(SeatUpdateInput input);

}
