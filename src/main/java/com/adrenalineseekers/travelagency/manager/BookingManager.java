package com.adrenalineseekers.travelagency.manager;

import com.adrenalineseekers.travelagency.model.Passenger;
import com.adrenalineseekers.travelagency.model.TravelPackage;

public interface BookingManager {
    void signUpPassengerTravelPackage(TravelPackage travelPackage, Passenger passenger);
    void signUpPassengerActivity(Passenger passenger, TravelPackage travelPackage, String destination, String activity);
}