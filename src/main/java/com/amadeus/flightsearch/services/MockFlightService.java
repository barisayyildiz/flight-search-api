package com.amadeus.flightsearch.services;

import com.amadeus.flightsearch.models.Flight;
import com.amadeus.flightsearch.repository.FlightRepository;
import com.amadeus.flightsearch.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MockFlightService {
    public final FlightRepository flightRepository;
    public List<Flight> getMockFlightList() {
        List<Flight> flights = Utils.readMockFlights("flights.json");
        if (flights != null && !flights.isEmpty()) {
            flightRepository.saveAll(flights);
            return flights;
        } else {
            return null;
        }
    }
}
