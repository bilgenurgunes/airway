package com.example.airway.controller;

import com.example.airway.data.FlightDTO;
import com.example.airway.entity.Flight;
import com.example.airway.service.FlightsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightsController {

    public static final Logger LOG = LoggerFactory.getLogger(FlightsController.class);

    private FlightsService flightsService;

    @Autowired
    public void setFlightsService(FlightsService flightsService) {
        this.flightsService = flightsService;
    }

    @GetMapping("/{id}")
    public Flight getFlight(@PathVariable Long id) {
        return flightsService.findFlightById(id);
    }

    @GetMapping()
    public List<Flight> getFlight() {
        return flightsService.getAllFlights();
    }

    @PostMapping
    public Flight addFlight(@RequestBody FlightDTO flightDTO) {
        LOG.info("addFlight: {} ", flightDTO);
        return flightsService.addFlight(flightDTO);
    }

}
