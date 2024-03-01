package com.adrenalineseekers.travelagency.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TravelPackage {
    private String name;
    private int capacity;
    private List<Destination> destinations;
    private List<Passenger> passengers;
}
