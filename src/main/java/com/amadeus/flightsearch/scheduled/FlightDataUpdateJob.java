package com.amadeus.flightsearch.scheduled;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class FlightDataUpdateJob {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private final RestTemplate restTemplate;

    private String mockApiUrl = "http://localhost:8080/mock/flight";

    @Scheduled(cron = "0 0 0 * * ?")
    public void updateFlightData() {
        restTemplate.getForEntity(mockApiUrl, String.class);
        System.out.println("Updated at: " + dateFormat.format(new Date()));
    }
}
