package com.amadeus.flightsearch.controllers;

import com.amadeus.flightsearch.models.dto.FlightSearchRequest;
import com.amadeus.flightsearch.models.dto.FlightSearchResponse;
import com.amadeus.flightsearch.services.FlightSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FlightSearchController {
    private final FlightSearchService flightSearchService;

    @GetMapping("/flightsearch")
    public ResponseEntity<FlightSearchResponse> searchFlights(
            @RequestBody FlightSearchRequest searchRequest
    ) {
        FlightSearchResponse searchResponse = flightSearchService.searchFlights(searchRequest);
        return new ResponseEntity<>(searchResponse, HttpStatus.OK);
    }

}
