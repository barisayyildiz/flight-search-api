package com.amadeus.flightsearch.controllers;

import com.amadeus.flightsearch.models.Flight;
import com.amadeus.flightsearch.repository.FlightRepository;
import com.amadeus.flightsearch.services.MockFlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MockFlightController {
    private final FlightRepository flightRepository;
    private final MockFlightService mockFlightService;
    @GetMapping("mock/flight")
    public ResponseEntity<?> getMockFlights() {
        List<Flight> flights = mockFlightService.getMockFlightList();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }
}
