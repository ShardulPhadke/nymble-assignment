package com.adrenalineseekers.travelagency.model;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Booking {
    private int passengerId;
    private TravelPackage travelPackage;
    private Map<Destination, List<Activity>> destinationActivitiesMap;
    private int totalCost;
}
