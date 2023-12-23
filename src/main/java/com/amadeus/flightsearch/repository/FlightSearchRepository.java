package com.amadeus.flightsearch.repository;

import com.amadeus.flightsearch.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightSearchRepository extends JpaRepository<Flight, Long> {
    @Query(value =
            """
                select f from Flight f
                where f.departureAirport.id = :departureAirport and
                f.arrivalAirport.id = :arrivalAirport and
                f.departureDate = :departureDate
            """
    )
    List<Flight> searchFlights(
            @Param("departureAirport") String departureAirport,
            @Param("arrivalAirport") String arrivalAirport,
            @Param("departureDate") Long departureDate
    );
}
