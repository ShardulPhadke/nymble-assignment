package com.adrenalineseekers.travelagency.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.adrenalineseekers.travelagency.enums.PassengerType;
import com.adrenalineseekers.travelagency.model.Activity;
import com.adrenalineseekers.travelagency.model.Destination;
import com.adrenalineseekers.travelagency.model.Passenger;
import com.adrenalineseekers.travelagency.model.TravelPackage;

public class BookingManagerImpl implements BookingManager {

    @Override
    public void signUpPassengerTravelPackage(TravelPackage travelPackage, Passenger passenger) {
        System.out.println("Passenger name: " + passenger.getName());
        System.out.println("Travel Package selected: " + travelPackage.getName());
        System.out.println("Checking availability...");
        if (checkAvailability(travelPackage)) {
            passenger.setTravelPackage(travelPackage);
            List<Passenger> passengers = travelPackage.getPassengers();
            passengers.add(passenger);
            travelPackage.setPassengers(passengers);
            System.out.println("Successfully signed for travel package: " + travelPackage.getName());
        } else {
            System.out.println("Sorry the travel package " + travelPackage.getName() + " is fully booked");
        }
    }

    @Override
    public void signUpPassengerActivity(Passenger passenger, TravelPackage travelPackage, String destinationName,
            String activityName) {
        boolean destinationFound = false;
        boolean activityfound = false;
        System.out.println("Signing up for activity " + activityName + " at destination " + destinationName);
        for (Destination destination : travelPackage.getDestinations()) {
            if (destination.getName().equalsIgnoreCase(destinationName)) {
                destinationFound = true;
                for (Activity activity : destination.getActivities()) {
                    if (activity.getName().equalsIgnoreCase(activityName)) {
                        activityfound = true;
                        System.out.println("Checking for availability...");
                        if (activity.getCapacity() > 0) {
                            if (passengerPremiumCheck(passenger)) {
                                reserveActivitySpot(passenger, destination, activity);
                                if (!travelPackage.getPassengers().contains(passenger)) {
                                    addPassengerToEnrolledList(travelPackage, passenger);
                                }
                            } else {
                                if (balanceCheck(passenger, activity)) {
                                    reserveActivitySpot(passenger, destination, activity);
                                    if (!travelPackage.getPassengers().contains(passenger)) {
                                        addPassengerToEnrolledList(travelPackage, passenger);
                                    }
                                } else {
                                    System.out.println(
                                            "Sorry you have insufficient balance to sign up for this activity");
                                }
                            }
                        } else {
                            System.out.println("Sorry the activity " + activity.getName() + " is fully booked");
                        }
                    }
                }
            }
        }
        if (!destinationFound) {
            System.out.println(
                    "Destination " + destinationName + " not available in travel package " + travelPackage.getName());
        } else if (!activityfound) {
            System.out.println("Activity " + activityName + " not available at destination " + destinationName);
        }
    }

    private void addPassengerToEnrolledList(TravelPackage travelPackage, Passenger passenger) {
        List<Passenger> enrolledPassengers = travelPackage.getPassengers();
        enrolledPassengers.add(passenger);
        travelPackage.setPassengers(enrolledPassengers);
    }

    private boolean balanceCheck(Passenger passenger, Activity activity) {
        double discount = 0;
        if (passenger.getPassengerType() == PassengerType.GOLD) {
            discount = 0.1;
        }
        double activityCost = activity.getCost() - (activity.getCost() * discount);
        if (passenger.getBalance() - activityCost >= 0) {
            passenger.setBalance(passenger.getBalance() - activityCost);
            return true;
        } else {
            return false;
        }
    }

    private void reserveActivitySpot(Passenger passenger, Destination destination, Activity activity) {
        Map<Destination, List<Activity>> prevActivitiesSignedUpFor = passenger.getActivitiesSignedUpFor();
        if (prevActivitiesSignedUpFor.containsKey(destination)) {
            List<Activity> activities = new ArrayList<>(prevActivitiesSignedUpFor.get(destination));
            activities.add(activity);
            prevActivitiesSignedUpFor.put(destination, activities);
        } else {
            prevActivitiesSignedUpFor.put(destination, Arrays.asList(activity));
        }
        passenger.setActivitiesSignedUpFor(prevActivitiesSignedUpFor);
        activity.setCapacity(activity.getCapacity() - 1);
        System.out.println("Activity booked: " + activity.getName() + " for " + passenger.getName());
    }

    private boolean passengerPremiumCheck(Passenger passenger) {
        if (passenger.getPassengerType() == PassengerType.PREMIUM) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkAvailability(TravelPackage travelPackage) {
        if (travelPackage.getCapacity() > 0) {
            travelPackage.setCapacity(travelPackage.getCapacity() - 1);
            return true;
        } else {
            return false;
        }
    }
}
