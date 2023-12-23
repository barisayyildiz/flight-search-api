package com.amadeus.flightsearch.utils;

import com.amadeus.flightsearch.models.Flight;
import com.amadeus.flightsearch.models.dto.FlightResponse;
import com.amadeus.flightsearch.services.FlightService;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static long getEpochDateMillisecond(String isoDate) {
        ZonedDateTime startTime = ZonedDateTime.parse(isoDate);
        return startTime.toInstant().toEpochMilli();
    }

    public static String getIsoDateTime(long epochMilli) {
        Instant instant = Instant.ofEpochMilli(epochMilli);
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return zonedDateTime.format(formatter);
    }

    public static FlightResponse convertFlightResponse(Flight flight) {
        return FlightResponse
                .builder()
                .id(flight.getId())
                .departureAirport(flight.getDepartureAirport())
                .arrivalAirport(flight.getArrivalAirport())
                .departureDate(Utils.getIsoDateTime(flight.getDepartureDate()))
                .arrivalDate(Utils.getIsoDateTime(flight.getArrivalDate()))
                .price(flight.getPrice())
                .build();
    }

    public static List<FlightResponse> convertFlights(List<Flight> flights) {
        return flights.stream()
                .map(Utils::convertFlightResponse)
                .collect(Collectors.toList());
    }
}
