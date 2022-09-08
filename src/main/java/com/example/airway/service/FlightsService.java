package com.example.airway.service;

import com.example.airway.data.FlightDTO;
import com.example.airway.entity.Flight;
import com.example.airway.repository.FlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class FlightsService {

    private FlightsRepository flightsRepository;

    private Integer maximumFlightsBetweenCities;

    @Autowired
    public void setFlightsRepository(FlightsRepository flightsRepository) {
        this.flightsRepository = flightsRepository;
    }

    @Autowired
    public void setMaximumFlightsBetweenCities(@Value("${max.flights.between.cities}") Integer maximumFlightsBetweenCities) {
        this.maximumFlightsBetweenCities = maximumFlightsBetweenCities;
    }

    public Flight findFlightById(Long id) {
        Optional<Flight> flightOptional = flightsRepository.findById(id);
        return flightOptional.isPresent() ? flightOptional.get() : null;
    }

    public Flight addFlight(FlightDTO flightDTO) {
        validateMaximumFlightNumbers(flightDTO);

        Flight toBeAddedFlight = new Flight();
        toBeAddedFlight.setArrivalAirport(flightDTO.getArrival());
        toBeAddedFlight.setDepartureAirport(flightDTO.getDeparture());
        toBeAddedFlight.setPlaneId(flightDTO.getPlaneId());
        return flightsRepository.save(toBeAddedFlight);
    }

    private void validateMaximumFlightNumbers(FlightDTO flightDTO) {
        List<Flight> flightsBetweenCities =
                flightsRepository.findByDepartureAirportAndArrivalAirport(
                        flightDTO.getDeparture(), flightDTO.getArrival());
        if(flightsBetweenCities.size() >= maximumFlightsBetweenCities) {
            throw new HttpClientErrorException(HttpStatus.NOT_ACCEPTABLE, "We can not add more than " + maximumFlightsBetweenCities + " flights");
        }
    }

    public List<Flight> getAllFlights (){
        return flightsRepository.findAll();

    }


}
