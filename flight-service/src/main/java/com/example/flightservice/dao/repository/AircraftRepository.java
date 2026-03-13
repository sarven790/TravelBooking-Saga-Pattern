package com.example.flightservice.dao.repository;

import com.example.flightservice.dao.entity.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft,String> {


    /*Optional<Aircraft> findAllByBrandNameEqualsIgnoreCaseAndModelNoEqualsIgnoreCase(String brandName,
                                                                                      String modelNo);*/

    @Query("select a.id from Aircraft a where a.brandName = :brandName and a.modelNo =:modelNo")
    String getIdByBrandNameAndModelNo(@Param("brandName") String brandName,
                                      @Param("modelNo") String modelNo);

}
