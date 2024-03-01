package com.naturefirst.travelagency.mockdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adrenalineseekers.travelagency.model.TravelPackage;
import com.adrenalineseekers.travelagency.enums.PassengerType;
import com.adrenalineseekers.travelagency.model.Activity;
import com.adrenalineseekers.travelagency.model.Destination;
import com.adrenalineseekers.travelagency.model.Passenger;

public class MockData {

    public String expectedMockTravelHappyOutput = "Itinerary for mockPackage\n\n" +
            "Destination: mockDestination\n\n" +
            "  Activity: mockActivity\n" +
            "    Cost: 10.0\n" +
            "    Capacity: 10\n" +
            "    Description: mockDescription\n\n\n\n";

    public String expectedMockTravelNoDestinationOutput = "Itinerary for mockPackage\n\n" +
            "The package does not have any destinations yet \n\n\n";

    public String expectedMockPrintPassengerListHappyOutput = "Passenger List for mockPackage\n" +
            "Package Name: mockPackage\n" +
            "Passenger Capacity: 10\n" +
            "Number of Passengers Enrolled: 1\n" +
            "Passengers:\n" +
            "  Name: mockPassenger\n" +
            "  Passenger Number: 1\n\n";

    public String expectedPrintPassengerListNoEnrolledPassengersOutput = "Passenger List for mockPackage\n" +
            "Package Name: mockPackage\n" +
            "Passenger Capacity: 10\n" +
            "Number of Passengers Enrolled: 0\n" +
            "The package mockPackage does not have any enrolled passengers\n\n";

    public String expectedPassengerDetailsHappyOutput = "Looking for reservation details for passenger with ID: 1\n" +
            "Passenger details: \n" +
            "Passenger name: mockPassenger\n" +
            "Remaining balance: 50.0\n" +
            "Passenger type: STANDARD\n" +
            "Activities signed up for: \n" +
            "    Activity: mockActivity\n" +
            "    Destination: mockDestination\n" +
            "    Cost paid: 50.0\n\n\n";

    public String expectedPassengerDetailsNoEnrolledPassengersOutput = "Looking for reservation details for passenger with ID: 1\n"
            +
            "The travel package mockTravelPackage does not have a booking for passengerId 1\n";

    public String expectedAvailableActivitiesHappyOutput = "Here are all the available activities for the travel package mockTravelPackage\n"
            +
            "Activity name: mockActivity\n" +
            "Available spaces: 3\n\n";

    public String expectedAvailableActivitiesNoAvailableActivitiesOutput = "Here are all the available activities for the travel package mockTravelPackage\n"
            +
            "There are no available activities for the travel package mockTravelPackage\n";

    public String expectedSignUpPassengerTravelPackageHappyOutput = "Passenger name: mockPassenger\n" +
            "Travel Package selected: mockTravelPackage\n" +
            "Checking availability...\n" +
            "Successfully signed for travel package: mockTravelPackage\n";

    public String expectedSignUpPassengerTravelPackageFullCapacityOutput = "Passenger name: mockPassenger\n" +
            "Travel Package selected: mockTravelPackage\n" +
            "Checking availability...\n" +
            "Sorry the travel package mockTravelPackage is fully booked\n";

    public String expectedSignUpPassengerActivityHappyOutput = "Signing up for activity mockActivity at destination mockDestination\n"
            +
            "Checking for availability...\n" +
            "Activity booked: mockActivity for mockPassenger\n";

    public String expectedSignUpPassengerActivityFullCapacityOutput = "Signing up for activity mockActivity at destination mockDestination\n"
            +
            "Checking for availability...\n" +
            "Sorry the activity mockActivity is fully booked\n";

    public String expectedSignUpPassengerActivityInsufficientBalanceOutput = "Signing up for activity mockActivity at destination mockDestination\n"
            +
            "Checking for availability...\n" +
            "Sorry you have insufficient balance to sign up for this activity\n";

    public String expectedSignUpPassengerActivityIncorrectDestinationOutput = "Signing up for activity mockActivity at destination mockDestinationWrong\n"
            +
            "Destination mockDestinationWrong not available in travel package mockTravelPackage\n";

    public String expectedSignUpPassengerActivityIncorrectActivityOutput = "Signing up for activity mockActivityWrong at destination mockDestination\n"
            +
            "Activity mockActivityWrong not available at destination mockDestination\n";

    public TravelPackage mockTravelPackageHappy() {
        TravelPackage mockTravelPackage = new TravelPackage("mockPackage", 10, null, null);
        List<Destination> destinations = new ArrayList<>();
        List<Activity> activities = new ArrayList<>();
        Activity mockActivity = new Activity("mockActivity", "mockDescription", 10, 10);
        activities.add(mockActivity);
        Destination mockDestination = new Destination("mockDestination", activities);
        destinations.add(mockDestination);
        mockTravelPackage.setDestinations(destinations);
        return mockTravelPackage;
    }

    public TravelPackage mockTravelPackageNoDestination() {
        TravelPackage mockTravelPackage = new TravelPackage("mockPackage", 10, null, null);
        return mockTravelPackage;
    }

    public TravelPackage mockPrintPassengerListHappy() {
        TravelPackage mockTravelPackage = new TravelPackage("mockPackage", 10, null, null);
        List<Passenger> passengers = new ArrayList<>();
        Passenger mockEnrolledPassenger = new Passenger("mockPassenger", 1, PassengerType.STANDARD);
        passengers.add(mockEnrolledPassenger);
        mockTravelPackage.setPassengers(passengers);
        return mockTravelPackage;
    }

    public TravelPackage mockPrintPassengerListNoEnrolledPassengers() {
        TravelPackage mockTravelPackage = new TravelPackage("mockPackage", 10, null, new ArrayList<Passenger>());
        return mockTravelPackage;
    }

    public TravelPackage mockPassengerDetailsHappy() {
        TravelPackage mockTravelPackage = new TravelPackage("MockTravelPackage", 10, new ArrayList<>(),
                new ArrayList<>());
        List<Destination> destinations = new ArrayList<>();
        Destination mockDestination = new Destination("mockDestination", new ArrayList<>());
        List<Activity> activities = new ArrayList<>();
        Activity mockActivity = new Activity("mockActivity", "mockDescription", 50, 3);
        activities.add(mockActivity);
        mockDestination.setActivities(activities);
        mockTravelPackage.setDestinations(destinations);
        List<Passenger> passengers = new ArrayList<>();
        Passenger mockPassenger = new Passenger("mockPassenger", 1, 50, mockTravelPackage,
                new HashMap<Destination, List<Activity>>(), PassengerType.STANDARD);
        Map<Destination, List<Activity>> mockActivitiesMap = mockPassenger.getActivitiesSignedUpFor();
        mockActivitiesMap.put(mockDestination, activities);
        mockPassenger.setActivitiesSignedUpFor(mockActivitiesMap);
        passengers.add(mockPassenger);
        mockTravelPackage.setPassengers(passengers);
        return mockTravelPackage;
    }

    public TravelPackage mockPassengerDetailsNoEnrolledPassengers() {
        TravelPackage mockTravelPackage = new TravelPackage("mockTravelPackage", 10, null, new ArrayList<>());
        return mockTravelPackage;
    }

    public TravelPackage mockAvailableActivitiesHappy() {
        TravelPackage mockTravelPackage = new TravelPackage("mockTravelPackage", 10, new ArrayList<Destination>(),
                null);
        List<Destination> destinations = new ArrayList<>();
        List<Activity> activities = new ArrayList<>();
        Activity mockActivity = new Activity("mockActivity", "mockDescription", 30, 3);
        activities.add(mockActivity);
        Destination mockDestination = new Destination("mockDestination", new ArrayList<>());
        mockDestination.setActivities(activities);
        destinations.add(mockDestination);
        mockTravelPackage.setDestinations(destinations);
        return mockTravelPackage;
    }

    public TravelPackage mockAvailableActivitiesNoAvailableActivities() {
        TravelPackage mockTravelPackage = new TravelPackage("mockTravelPackage", 10, new ArrayList<Destination>(),
                null);
        List<Destination> destinations = new ArrayList<>();
        List<Activity> activities = new ArrayList<>();
        Activity mockActivity = new Activity("mockActivity", "mockDescription", 30, 0);
        activities.add(mockActivity);
        Destination mockDestination = new Destination("mockDestination", new ArrayList<>());
        mockDestination.setActivities(activities);
        destinations.add(mockDestination);
        mockTravelPackage.setDestinations(destinations);
        return mockTravelPackage;
    }

    public TravelPackage mockSignUpPassengerActivityHappy() {
        TravelPackage mockTravelPackage = new TravelPackage("mockTravelPackage", 10, new ArrayList<Destination>(),
                new ArrayList<>());
        List<Destination> destinations = new ArrayList<>();
        List<Activity> activities = new ArrayList<>();
        Activity mockActivity = new Activity("mockActivity", "mockDescription", 30, 3);
        activities.add(mockActivity);
        Destination mockDestination = new Destination("mockDestination", new ArrayList<>());
        mockDestination.setActivities(activities);
        destinations.add(mockDestination);
        mockTravelPackage.setDestinations(destinations);
        return mockTravelPackage;
    }

    public TravelPackage mockSignUpPassengerActivityFullCapacity() {
        TravelPackage mockTravelPackage = new TravelPackage("mockTravelPackage", 10, new ArrayList<Destination>(),
                new ArrayList<>());
        List<Destination> destinations = new ArrayList<>();
        List<Activity> activities = new ArrayList<>();
        Activity mockActivity = new Activity("mockActivity", "mockDescription", 30, 0);
        activities.add(mockActivity);
        Destination mockDestination = new Destination("mockDestination", new ArrayList<>());
        mockDestination.setActivities(activities);
        destinations.add(mockDestination);
        mockTravelPackage.setDestinations(destinations);
        return mockTravelPackage;
    }

}
