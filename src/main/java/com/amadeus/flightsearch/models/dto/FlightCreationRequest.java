package com.amadeus.flightsearch.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightCreationRequest {
    @NotBlank
    @NotNull
    private String departureAirport;
    @NotBlank
    @NotNull
    private String arrivalAirport;
    @NotBlank
    @NotNull
    private String departureDate;
    @NotBlank
    @NotNull
    private String arrivalDate;
    @NotNull
    private Double price;
}
