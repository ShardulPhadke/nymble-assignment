package com.adrenalineseekers.travelagency.manager;

import com.adrenalineseekers.travelagency.model.TravelPackage;

public interface TravelPackageManager {
    void printItinerary(TravelPackage travelPackage);
    void printPassengerList(TravelPackage travelPackage);
    public void passengerDetails(TravelPackage TravelPackage, int passengerId); 
    public void availableActivities(TravelPackage TravelPackage);
}
