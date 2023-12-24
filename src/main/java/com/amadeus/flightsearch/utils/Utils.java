package com.amadeus.flightsearch.utils;

import com.amadeus.flightsearch.models.Airport;
import com.amadeus.flightsearch.models.Flight;
import com.amadeus.flightsearch.models.dto.FlightResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static long getEpochDateSecond(String isoDate) {
        ZonedDateTime startTime = ZonedDateTime.parse(isoDate);
        return startTime.toEpochSecond();
    }

    public static String getIsoDateTime(long epochSecond) {
        Instant instant = Instant.ofEpochSecond(epochSecond);
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

    public static List<Flight> readMockFlights(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(
                    new ClassPathResource(filePath).getFile(),
                    new TypeReference<List<Flight>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Airport> readMockAirports(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(
                    new ClassPathResource(filePath).getFile(),
                    new TypeReference<List<Airport>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
