package com.example.flightservice.domain.service.impl;

import com.example.flightservice.dao.repository.SeatRepository;
import com.example.flightservice.dao.repository.dto.SeatDto;
import com.example.flightservice.domain.mapper.SeatDtoMapper;
import com.example.flightservice.domain.model.input.SeatInput;
import com.example.flightservice.domain.model.input.SeatListInput;
import com.example.flightservice.domain.model.input.SeatUpdateInput;
import com.example.flightservice.domain.model.output.SeatListOutput;
import com.example.flightservice.domain.model.output.SeatOutput;
import com.example.flightservice.domain.service.SeatService;
import com.example.flightservice.domain.util.AircraftUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;
    private final AircraftUtil aircraftUtil;

    @Override
    public void addSeat(SeatInput input) {

    }

    @Override
    public SeatOutput getSeatByNo(SeatInput input) {

        String id = seatRepository
                .getSeatByNoAndStatusIsAvailable(input.getNo());

        var seat = seatRepository.getReferenceById(id);

        return SeatOutput.builder()
                .seat(seat)
                .build();
    }

    @Override
    public SeatListOutput seatList(SeatListInput input) {

        var aircraft = aircraftUtil.findByAircraftByBrandAndModel(input);

        List<SeatDto> seats = SeatDtoMapper.toDtoList(seatRepository.findAllByAircraft_Id(aircraft.getId()));

        return SeatListOutput.builder()
                .seatDtoList(seats)
                .build();

    }

    @Override
    public void updateSeatStatus(SeatUpdateInput input) {
        var seat = input.getSeat();
        seat.setStatus(input.getSeatStatus());
    }
}
