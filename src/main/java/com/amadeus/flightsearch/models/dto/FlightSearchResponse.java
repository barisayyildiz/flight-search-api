package com.amadeus.flightsearch.models.dto;

import com.amadeus.flightsearch.models.Flight;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class FlightSearchResponse {
    private List<FlightResponse> outbound;
    private List<FlightResponse> returnFlights;
}
