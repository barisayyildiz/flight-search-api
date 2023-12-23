package com.amadeus.flightsearch.models.dto;

import com.amadeus.flightsearch.models.Airport;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightResponse {
    private Long id;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private String departureDate;
    private String arrivalDate;
    private Double price;
}
