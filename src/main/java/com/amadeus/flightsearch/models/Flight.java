package com.amadeus.flightsearch.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
    name = "flight",
    uniqueConstraints = {
        @UniqueConstraint(name="uc_flightid", columnNames = {"id"})
    }
)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id", nullable = false)
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id", nullable = false)
    private Airport arrivalAirport;

    @Column(name="departure_date_time", columnDefinition="int8")
    private Long departureDate;

    @Column(name="arrival_date_time", columnDefinition="int8")
    private Long arrivalDate;

    @Column(name="price", columnDefinition="DECIMAL(10,2)")
    private Double price;
}
