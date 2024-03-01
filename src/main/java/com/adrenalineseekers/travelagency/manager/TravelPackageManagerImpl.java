package com.adrenalineseekers.travelagency.manager;

import java.util.List;
import java.util.Map;

import com.adrenalineseekers.travelagency.model.Activity;
import com.adrenalineseekers.travelagency.model.Destination;
import com.adrenalineseekers.travelagency.model.Passenger;
import com.adrenalineseekers.travelagency.model.TravelPackage;

public class TravelPackageManagerImpl implements TravelPackageManager {

    @Override
    public void printItinerary(TravelPackage travelPackage) {
        System.out.println("Itinerary for " + travelPackage.getName() + "\n");
        if (travelPackage.getDestinations() != null) {
            for (Destination destination : travelPackage.getDestinations()) {
                System.out.println("Destination: " + destination.getName() + "\n");
                for (Activity activity : destination.getActivities()) {
                    System.out.println("  Activity: " + activity.getName());
                    System.out.println("    Cost: " + activity.getCost());
                    System.out.println("    Capacity: " + activity.getCapacity());
                    System.out.println("    Description: " + activity.getDescription());
                    System.out.println("\n");
                }
            }
        } else {
            System.out.println("The package does not have any destinations yet \n");
        }

        System.out.println();
    }

    @Override
    public void printPassengerList(TravelPackage travelPackage) {
        System.out.println("Passenger List for " + travelPackage.getName());
        System.out.println("Package Name: " + travelPackage.getName());
        System.out.println("Passenger Capacity: " + travelPackage.getCapacity());
        System.out.println("Number of Passengers Enrolled: " + travelPackage.getPassengers().size());
        if(travelPackage.getPassengers().size() > 0) {
            System.out.println("Passengers:");
            for (Passenger passenger : travelPackage.getPassengers()) {
                System.out.println("  Name: " + passenger.getName());
                System.out.println("  Passenger Number: " + passenger.getPassengerId());
            }
            System.out.println();
        } else {
            System.out.println("The package " + travelPackage.getName() + " does not have any enrolled passengers\n");
        }
    }

    @Override
    public void passengerDetails(TravelPackage travelPackage, int passengerId) {
        System.out.println("Looking for reservation details for passenger with ID: " + passengerId);
        List<Passenger> enrolledPassengers = travelPackage.getPassengers();
        boolean passengerFound = false;
        for (Passenger passenger : enrolledPassengers) {
            if (passenger.getPassengerId() == passengerId) {
                passengerFound = true;
                System.out.println("Passenger details: ");
                System.out.println("Passenger name: " + passenger.getName());
                System.out.println("Remaining balance: " + passenger.getBalance());
                System.out.println("Passenger type: " + passenger.getPassengerType());
                System.out.println("Activities signed up for: ");
                for (Map.Entry<Destination, List<Activity>> entry : passenger.getActivitiesSignedUpFor().entrySet()) {
                    Destination destination = entry.getKey();
                    List<Activity> activities = entry.getValue();
                    for (Activity activity : activities) {
                        System.out.println("    Activity: " + activity.getName());
                        System.out.println("    Destination: " + destination.getName());
                        double costPaid = 0;
                        switch (passenger.getPassengerType()) {
                            case PREMIUM:
                                costPaid = 0;
                                break;
                            case GOLD:
                                costPaid = activity.getCost() - (activity.getCost() * 0.1);
                                break;
                            case STANDARD:
                                costPaid = activity.getCost();
                                break;
                            default:
                                break;
                        }
                        System.out.println("    Cost paid: " + costPaid);
                        System.out.println("\n");
                    }
                }
            }
        }
        if (!passengerFound) {
            System.out.println("The travel package " + travelPackage.getName()
                    + " does not have a booking for passengerId " + passengerId);
        }
    }

    @Override
    public void availableActivities(TravelPackage travelPackage) {
        System.out.println("Here are all the available activities for the travel package " + travelPackage.getName());
        boolean freeActivities = false;
        for (Destination destination : travelPackage.getDestinations()) {
            for (Activity activity : destination.getActivities()) {
                if (activity.getCapacity() > 0) {
                    freeActivities = true;
                    System.out.println("Activity name: " + activity.getName());
                    System.out.println("Available spaces: " + activity.getCapacity() + "\n");
                }
            }
        }
        if (!freeActivities) {
            System.out.println("There are no available activities for the travel package " + travelPackage.getName());
        }
    }

}
