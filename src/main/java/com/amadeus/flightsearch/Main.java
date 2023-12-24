package com.amadeus.flightsearch;

import com.amadeus.flightsearch.models.Airport;
import com.amadeus.flightsearch.repository.AirportRepository;
import com.amadeus.flightsearch.services.MockFlightService;
import com.amadeus.flightsearch.utils.Utils;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@EnableScheduling
public class Main {

	public final AirportRepository airportRepository;
	public final MockFlightService mockFlightService;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@PostConstruct
	public void initDb() {
		List<Airport> airports = Utils.readMockAirports("airports.json");
		if (airports != null && !airports.isEmpty()) {
			airportRepository.saveAll(airports);
		}
		mockFlightService.getMockFlightList();
	}

}
