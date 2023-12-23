package com.amadeus.flightsearch.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AirportCreationRequest {
    @JsonProperty("id")
    @NotBlank
    @NotNull
    private String id;

    @JsonProperty("city")
    @NotBlank
    @NotNull
    private String city;
}
