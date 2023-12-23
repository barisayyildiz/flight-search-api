package com.amadeus.flightsearch.controllers;

import com.amadeus.flightsearch.models.dto.AirportCreationRequest;
import com.amadeus.flightsearch.models.dto.AirportUpdateRequest;
import com.amadeus.flightsearch.services.AirportService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class AirportController {
    private final AirportService airportService;

    @GetMapping("/airport")
    public ResponseEntity<?> getAllAirports(HttpServletRequest request) {
        return new ResponseEntity<>(airportService.getAllAirports(), HttpStatus.OK);
    }

    @GetMapping("/airport/{id}")
    public ResponseEntity<?> getAirport(
            @PathVariable String id,
            HttpServletRequest request
    ) {
        return new ResponseEntity<>(airportService.getAirport(id), HttpStatus.OK);
    }

    @PostMapping("/airport")
    public ResponseEntity<?> createAirport(
            @Valid  @RequestBody AirportCreationRequest request
        ) {
        return new ResponseEntity<>(airportService.createAirport(request.getId(), request.getCity()), HttpStatus.CREATED);
    }

    @PutMapping("/airport/{id}")
    public ResponseEntity<?> updateAirport(
            @PathVariable String id,
            @RequestBody AirportUpdateRequest request
    ) {
        return new ResponseEntity<>(airportService.updateAirport(id, request), HttpStatus.CREATED);
    }

    @DeleteMapping("/airport/{id}")
    public ResponseEntity<?> deleteAirport(
            @PathVariable String id,
            HttpServletRequest request
    ) {
        airportService.deleteAirport(id);
        return new ResponseEntity<>(Collections.emptyMap(), HttpStatus.NO_CONTENT);
    }
}
