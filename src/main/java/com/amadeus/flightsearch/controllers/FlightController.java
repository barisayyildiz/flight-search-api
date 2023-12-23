package com.amadeus.flightsearch.controllers;

import com.amadeus.flightsearch.models.Flight;
import com.amadeus.flightsearch.models.dto.FlightCreationRequest;
import com.amadeus.flightsearch.models.dto.FlightResponse;
import com.amadeus.flightsearch.models.dto.FlightUpdateRequest;
import com.amadeus.flightsearch.services.FlightService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @GetMapping("/flight")
    public ResponseEntity<List<FlightResponse>> getAllFlights() {
        return new ResponseEntity<>(flightService.getAllFlights(), HttpStatus.OK);
    }

    @GetMapping("/flight/{id}")
    public ResponseEntity<FlightResponse> getFlight(@PathVariable Long id) {
        return new ResponseEntity<>(flightService.getFlight(id), HttpStatus.OK);
    }

    @PostMapping("/flight")
    public ResponseEntity<FlightResponse> createFlight(
            @Valid @RequestBody FlightCreationRequest request
    ) {
        return new ResponseEntity<>(flightService.createFlight(request), HttpStatus.CREATED);
    }

    @PutMapping("/flight/{id}")
    public ResponseEntity<FlightResponse> updateFlight(
            @PathVariable Long id,
            @Valid @RequestBody FlightUpdateRequest request
    ) {
        return new ResponseEntity<>(flightService.updateFlight(id, request), HttpStatus.CREATED);
    }

    @DeleteMapping("/flight/{id}")
    public ResponseEntity<?> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
