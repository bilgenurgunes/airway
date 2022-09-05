package com.example.airway.repository;

import com.example.airway.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightsRepository extends JpaRepository <Flight, Long>{

    Optional<Flight> findById(Long id);


    List<Flight> findByDepartureAirportAndArrivalAirport(String departure, String arrival);
}
