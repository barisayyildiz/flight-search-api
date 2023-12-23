package com.amadeus.flightsearch.services;

import com.amadeus.flightsearch.models.dto.FlightResponse;
import com.amadeus.flightsearch.models.dto.FlightSearchRequest;
import com.amadeus.flightsearch.models.dto.FlightSearchResponse;
import com.amadeus.flightsearch.repository.FlightSearchRepository;
import com.amadeus.flightsearch.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FlightSearchService {
    private final FlightSearchRepository flightSearchRepository;

    public FlightSearchResponse searchFlights(FlightSearchRequest request) {
        List<FlightResponse> outboundFlights = flightSearchRepository.searchFlights(
                request.getDepartureAirport(),
                request.getArrivalAirport(),
                Utils.getEpochDateMillisecond(request.getDepartureDate())
        ).stream()
                .map(Utils::convertFlightResponse)
                .toList();
        List<FlightResponse> returnFlights = List.of();
        if (request.getReturnDate() != null) {
            returnFlights = flightSearchRepository.searchFlights(
                            request.getDepartureAirport(),
                            request.getArrivalAirport(),
                            Utils.getEpochDateMillisecond(request.getReturnDate())
                    ).stream()
                    .map(Utils::convertFlightResponse)
                    .toList();
        }
        return FlightSearchResponse.builder()
                .outbound(outboundFlights)
                .returnFlights(returnFlights)
                .build();
    }
}
