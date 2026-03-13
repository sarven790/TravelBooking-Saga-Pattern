package com.example.flightservice.domain.util;

import com.example.flightservice.dao.entity.Aircraft;
import com.example.flightservice.dao.repository.AircraftRepository;
import com.example.flightservice.domain.model.input.AircraftInputByName;
import com.example.flightservice.domain.model.input.SeatListInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class AircraftUtil {

    private final AircraftRepository aircraftRepository;

    public Aircraft findByAircraftByBrandAndModel(SeatListInput input) {
        return getAircraft(input.getAircraftBrandName(),input.getAircraftModelNo());
    }

    public Aircraft findByAircraftByBrandAndModel(AircraftInputByName input) {
        Aircraft aircraft = null;
        if (!Objects.isNull(input.getAirName())
                && input.getAirName().contains("_")) {
            String[] inputList = input.getAirName().split("_");

            aircraft = getAircraft(inputList[0],inputList[1]);
        }
        return aircraft;
    }

    private Aircraft getAircraft(String brandName, String modelNo) {
        Aircraft aircraft = null;
        String id = aircraftRepository
                .getIdByBrandNameAndModelNo(
                        brandName,modelNo);

        if (!Objects.isNull(id)) {
            aircraft = getAircraftByReferenceId(id);
        }
        return aircraft;
    }

    private Aircraft getAircraftByReferenceId(String id) {
        return aircraftRepository.getReferenceById(id);
    }

}
