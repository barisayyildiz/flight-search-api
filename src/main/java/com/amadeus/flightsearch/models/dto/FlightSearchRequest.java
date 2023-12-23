package com.amadeus.flightsearch.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightSearchRequest {
    @NotBlank
    @NotNull
    private String departureAirport;
    @NotBlank
    @NotNull
    private String arrivalAirport;
    @NotBlank
    @NotNull
    private String departureDate;
    private String returnDate;
}
