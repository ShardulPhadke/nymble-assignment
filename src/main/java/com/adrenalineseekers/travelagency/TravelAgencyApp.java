package com.adrenalineseekers.travelagency;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.adrenalineseekers.travelagency.enums.PassengerType;
import com.adrenalineseekers.travelagency.manager.BookingManager;
import com.adrenalineseekers.travelagency.manager.TravelPackageManager;
import com.adrenalineseekers.travelagency.model.Activity;
import com.adrenalineseekers.travelagency.model.Destination;
import com.adrenalineseekers.travelagency.model.Passenger;
import com.adrenalineseekers.travelagency.model.TravelPackage;

@Component
public class TravelAgencyApp implements CommandLineRunner {
    private final TravelPackageManager travelPackageManager;
    private final BookingManager bookingManager;

    @Autowired
    public TravelAgencyApp(TravelPackageManager travelPackageManager, BookingManager bookingManager) {
        this.travelPackageManager = travelPackageManager;
        this.bookingManager = bookingManager;
    }

    @Override
    public void run(String... args) throws Exception {
        // Creating Travel Packages, adding destinations and activities
        TravelPackage australia = new TravelPackage("Australia", 10, new ArrayList<Destination>(),
                new ArrayList<Passenger>());
        TravelPackage india = new TravelPackage("India", 10, new ArrayList<Destination>(), new ArrayList<Passenger>());
        travelPackagesInit(india, australia);
        travelPackageManager.printItinerary(india);

        Passenger passenger1 = new Passenger("Ben Bohmer", 1, PassengerType.STANDARD);
        Passenger passenger2 = new Passenger("Carl Cox", 2, PassengerType.GOLD);
        Passenger passenger3 = new Passenger("Bob Moses", 3, PassengerType.PREMIUM);
        Passenger passenger4 = new Passenger("David August", 4, PassengerType.STANDARD);
        // for setting custom balance use the constructor with the balance parameter
        Passenger passenger10 = new Passenger("Christian Loffler", 10, 1000, PassengerType.STANDARD);

        // // Sign up passenger for a travel package and activities in that package.
        bookingManager.signUpPassengerTravelPackage(india, passenger1);
        bookingManager.signUpPassengerTravelPackage(india, passenger2);
        bookingManager.signUpPassengerTravelPackage(india, passenger3);
        bookingManager.signUpPassengerTravelPackage(india, passenger4);

        // Signing up passsengers for activities
        bookingManager.signUpPassengerActivity(passenger1, passenger1.getTravelPackage(), "Ladakh", "Trekking");
        bookingManager.signUpPassengerActivity(passenger3, passenger3.getTravelPackage(), "Ladakh", "Trekking");

        // Signing up passenger 2 for multiple activities
        bookingManager.signUpPassengerActivity(passenger2, passenger2.getTravelPackage(), "Ladakh", "Trekking");
        bookingManager.signUpPassengerActivity(passenger2, passenger2.getTravelPackage(), "Ladakh", "Trail Biking");
        
        // The passenger cannot signup for the below activity as they do not have the sufficient balance
        bookingManager.signUpPassengerActivity(passenger2, passenger2.getTravelPackage(), "Ladakh", "River Rafting");
        System.out.println("\n");

        // The logs will show the trekking activity as fully booked when we want to signup passenger4
        bookingManager.signUpPassengerActivity(passenger4, passenger4.getTravelPackage(), "Ladakh", "Trekking");
        System.out.println("\n");

        // This will show the passenger details for passenger2
        travelPackageManager.passengerDetails(india, 2);
        travelPackageManager.availableActivities(india);
    }

    public void travelPackagesInit(TravelPackage india, TravelPackage australia) {
        List<Destination> australiaDestinations = new ArrayList<Destination>();

        List<Activity> goldCoastActivities = new ArrayList<Activity>();
        Activity activityGoldCoast1 = new Activity("Snorkelling",
                "Explore the marine biology off the coast of Australia", 20, 5);
        Activity activityGoldCoast2 = new Activity("Scuba Diving", "Swim with deep sea creatures", 40, 3);
        Activity activityGoldCoast3 = new Activity("Jet Ski", "Zip around on jet skis through the blue ocean waters",
                10, 3);
        Activity activityGoldCoast4 = new Activity("Wakeboarding", "Ride the Wake, feel the thrill", 10, 3);
        goldCoastActivities.add(activityGoldCoast1);
        goldCoastActivities.add(activityGoldCoast2);
        goldCoastActivities.add(activityGoldCoast3);
        goldCoastActivities.add(activityGoldCoast4);
        Destination goldCoast = new Destination("Gold Coast", goldCoastActivities);
        australiaDestinations.add(goldCoast);

        List<Activity> newSouthWalesActivities = new ArrayList<Activity>();
        Activity newSouthWalesActivity1 = new Activity("Skydiving",
                "Tandem skydiving offering views of the Illawarra coastline and the Royal National Park.", 60, 3);
        Activity newSouthWalesActivity2 = new Activity("Paragliding", "Exhilarating paragliding experience in Manilla",
                40, 2);
        Activity newSouthWalesActivity3 = new Activity("Bungee Jumping",
                "Take a leap of faith with a bungee jump at the AJ Hackett Penrith site", 20, 5);
        newSouthWalesActivities.add(newSouthWalesActivity1);
        newSouthWalesActivities.add(newSouthWalesActivity2);
        newSouthWalesActivities.add(newSouthWalesActivity3);
        Destination newSouthWales = new Destination("New South Wales", newSouthWalesActivities);
        australiaDestinations.add(newSouthWales);
        australia.setDestinations(australiaDestinations);

        List<Destination> indiaDestinations = new ArrayList<Destination>();

        List<Activity> ladakhActivities = new ArrayList<Activity>();
        Activity ladakhActivity1 = new Activity("Trekking", "High altitude trekking in the remote mountains of ladakh",
                50, 3);
        Activity ladakhActivity2 = new Activity("Trail Biking", "Ride across desert terrains on two wheels", 50, 5);
        Activity ladakhActivity3 = new Activity("River Rafting",
                "Experience the thrill of white-water rafting in the Indus and Zanskar Rivers", 30, 3);
        Activity ladakhActivity4 = new Activity("Rock Climbing",
                "Challenge yourself as a beginner or a expert across various difficulties", 20, 5);
        ladakhActivities.add(ladakhActivity1);
        ladakhActivities.add(ladakhActivity2);
        ladakhActivities.add(ladakhActivity3);
        ladakhActivities.add(ladakhActivity4);
        Destination ladakh = new Destination("Ladakh", ladakhActivities);
        indiaDestinations.add(ladakh);

        List<Activity> girNationalParkActivities = new ArrayList<Activity>();
        Activity girNationalParkActivity1 = new Activity("Jungle Safari",
                "The only place in India to watch the majestics Asiatic lions in the wild", 20, 6);
        Activity girNationalParkActivity2 = new Activity("Riverside Camping",
                "Spend the night among the nature and under starts along the Hiran river", 40, 3);
        Activity girNationalParkActivity3 = new Activity("Nature Walks",
                "Observe the smaller wildlife, birds, and the park's ecosystem up close", 20, 4);
        girNationalParkActivities.add(girNationalParkActivity1);
        girNationalParkActivities.add(girNationalParkActivity2);
        girNationalParkActivities.add(girNationalParkActivity3);
        Destination girNationalPark = new Destination("Gir National Park", girNationalParkActivities);
        indiaDestinations.add(girNationalPark);
        india.setDestinations(indiaDestinations);
    }
}
