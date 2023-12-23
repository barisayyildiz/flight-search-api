package com.amadeus.flightsearch.services;

import com.amadeus.flightsearch.models.Airport;
import com.amadeus.flightsearch.models.Flight;
import com.amadeus.flightsearch.models.dto.FlightCreationRequest;
import com.amadeus.flightsearch.models.dto.FlightResponse;
import com.amadeus.flightsearch.models.dto.FlightUpdateRequest;
import com.amadeus.flightsearch.repository.AirportRepository;
import com.amadeus.flightsearch.repository.FlightRepository;
import com.amadeus.flightsearch.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FlightService {
    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;

    public List<FlightResponse> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return Utils.convertFlights(flights);
    }

    public FlightResponse getFlight(Long id) {
        Flight flight = flightRepository.findById(id).orElse(null);
        if (flight == null) {
            return null;
        }
        return Utils.convertFlightResponse(flight);
    }

    public FlightResponse createFlight(FlightCreationRequest request) {
        Airport departureAirport = airportRepository.findById(request.getDepartureAirport()).orElse(null);
        Airport arrivalAirport = airportRepository.findById(request.getArrivalAirport()).orElse(null);

        if(departureAirport == null || arrivalAirport == null) {
            return null;
        }

        Flight flight = Flight.builder()
                .departureAirport(departureAirport)
                .arrivalAirport(arrivalAirport)
                .departureDate(Utils.getEpochDateMillisecond(request.getDepartureDate()))
                .arrivalDate(Utils.getEpochDateMillisecond(request.getArrivalDate()))
                .price(request.getPrice())
                .build();

        flightRepository.save(flight);
        return Utils.convertFlightResponse(flight);
    }

    public FlightResponse updateFlight(Long id, FlightUpdateRequest request) {
        Flight existingFlight = flightRepository.findById(id).orElse(null);
        if(existingFlight == null) {
            return null;
        }

        Airport updatedDepartureAirport = null;
        Airport updatedArrivalAirport = null;

        if(request.getDepartureAirport() != null) {
            updatedDepartureAirport = airportRepository.findById(request.getDepartureAirport()).orElse(null);
        }
        if(request.getArrivalAirport() != null) {
            updatedArrivalAirport = airportRepository.findById(request.getArrivalAirport()).orElse(null);
        }
        if (updatedDepartureAirport != null) {
            existingFlight.setDepartureAirport(updatedDepartureAirport);
        }
        if (updatedArrivalAirport != null) {
            existingFlight.setArrivalAirport(updatedArrivalAirport);
        }
        if (request.getDepartureDate() != null) {
            existingFlight.setDepartureDate(Utils.getEpochDateMillisecond(request.getDepartureDate()));
        }
        if (request.getArrivalDate() != null) {
            existingFlight.setArrivalDate(Utils.getEpochDateMillisecond(request.getArrivalDate()));
        }
        if(request.getPrice() != null) {
            existingFlight.setPrice(request.getPrice());
        }


        flightRepository.save(existingFlight);
        return Utils.convertFlightResponse(existingFlight);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

}
