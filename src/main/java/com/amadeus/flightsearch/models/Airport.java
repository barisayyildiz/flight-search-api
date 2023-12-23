package com.amadeus.flightsearch.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(
    name = "airport",
    uniqueConstraints = {
        @UniqueConstraint(name="uc_airportid", columnNames = {"id"})
    }
)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Airport implements Serializable {
    @Id
    @Column(name="id", columnDefinition = "varchar(3)")
    private String id;

    @Column(name="city", columnDefinition = "varchar(64)")
    private String city;
}
