package com.amadeus.flightsearch.services;

import com.amadeus.flightsearch.models.Airport;
import com.amadeus.flightsearch.models.dto.AirportUpdateRequest;
import com.amadeus.flightsearch.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AirportService {
    private final AirportRepository airportRepository;

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Airport getAirport(String id) {
        return airportRepository.findById(id).orElse(null);
    }

    public Airport createAirport(String id, String city) {
        Airport airport = Airport.builder()
                .id(id)
                .city(city)
                .build();
        airportRepository.save(airport);
        return airport;
    }

    public Airport updateAirport(String id, AirportUpdateRequest request) {
        return airportRepository.findById(id)
                .map(currentAirport -> {
                    if(!request.getCity().isEmpty()) {
                        currentAirport.setCity(request.getCity());
                    }
                    airportRepository.save(currentAirport);
                    return currentAirport;
                })
                .orElse(null);
    }

    public void deleteAirport(String id) {
        airportRepository.deleteById(id);
    }

}
