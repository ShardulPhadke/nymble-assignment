package com.adrenalineseekers.travelagency.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adrenalineseekers.travelagency.enums.PassengerType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Passenger {
    private String name;
    private int passengerId;
    private double balance;
    private TravelPackage travelPackage;
    private Map<Destination, List<Activity>> activitiesSignedUpFor;
    private PassengerType passengerType;

    public Passenger(String name, int passengerId, PassengerType passengerType) {
        this.name = name;
        this.passengerId = passengerId;
        this.passengerType = passengerType;
        this.balance = 100;
        this.travelPackage = null;
        this.activitiesSignedUpFor = new HashMap<Destination, List<Activity>>();
    }

    // construtor for setting custom balance
    public Passenger(String name, int passengerId, double balance, PassengerType passengerType) {
        this.name = name;
        this.passengerId = passengerId;
        this.passengerType = passengerType;
        this.balance = balance;
        this.travelPackage = null;
        this.activitiesSignedUpFor = new HashMap<Destination, List<Activity>>();
    }
}
