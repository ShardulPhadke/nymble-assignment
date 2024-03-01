package com.naturefirst.travelagency;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.adrenalineseekers.travelagency.manager.TravelPackageManager;
import com.adrenalineseekers.travelagency.manager.TravelPackageManagerImpl;
import com.adrenalineseekers.travelagency.model.TravelPackage;

import com.naturefirst.travelagency.mockdata.MockData;

public class TravelPackageManagerTest {
    
    private TravelPackageManager travelPackageManager;
    private MockData mockData;

    @BeforeEach
    void setUp() {
        travelPackageManager = new TravelPackageManagerImpl();
        mockData = new MockData();
    }

    @Test
    void testPrintItenaryHappy() {
        TravelPackage mockTravelPackage = mockData.mockTravelPackageHappy();
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        travelPackageManager.printItinerary(mockTravelPackage);
        assertEquals(mockData.expectedMockTravelHappyOutput, outContent.toString());

        System.setOut(System.out);
    }

    @Test
    void testPrintItenaryNoDestinations() {
        TravelPackage mockTravelPackage = mockData.mockTravelPackageNoDestination();
       
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        travelPackageManager.printItinerary(mockTravelPackage);
        assertEquals(mockData.expectedMockTravelNoDestinationOutput, outContent.toString());

        System.setOut(System.out);
    }

    @Test
    void testPrintPassengerListHappy() {
        TravelPackage mockTravelPackage = mockData.mockPrintPassengerListHappy();
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        travelPackageManager.printPassengerList(mockTravelPackage);
        assertEquals(mockData.expectedMockPrintPassengerListHappyOutput, outContent.toString());

        System.setOut(System.out);
    }

    @Test 
    void testPrintPassengerListNoEnrolledPassengers() {
        TravelPackage mockTravelPackage = mockData.mockPrintPassengerListNoEnrolledPassengers();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        travelPackageManager.printPassengerList(mockTravelPackage);
        assertEquals(mockData.expectedPrintPassengerListNoEnrolledPassengersOutput, outContent.toString());

        System.setOut(System.out);
    }

    @Test
    void testPassengerDetailsHappy() {
        TravelPackage mockTravelPackage = mockData.mockPassengerDetailsHappy();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        travelPackageManager.passengerDetails(mockTravelPackage, 1);
        assertEquals(mockData.expectedPassengerDetailsHappyOutput, outContent.toString());
        
        System.setOut(System.out);
    }

    @Test
    void testPassengerDetailsNoEnrolledPasenger() {
        TravelPackage mockTravelPackage = mockData.mockPassengerDetailsNoEnrolledPassengers();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        travelPackageManager.passengerDetails(mockTravelPackage, 1);
        assertEquals(mockData.expectedPassengerDetailsNoEnrolledPassengersOutput, outContent.toString());
        
        System.setOut(System.out);
    }

    @Test
    void testAvailableActivitiesHappy() {
        TravelPackage mockTravelPackage = mockData.mockAvailableActivitiesHappy();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        travelPackageManager.availableActivities(mockTravelPackage);
        assertEquals(mockData.expectedAvailableActivitiesHappyOutput, outContent.toString());
        
        System.setOut(System.out);
    }

    @Test
    void testAvailableActivitiesNoAvailableActivities() {
        TravelPackage mockTravelPackage = mockData.mockAvailableActivitiesNoAvailableActivities();
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        travelPackageManager.availableActivities(mockTravelPackage);
        assertEquals(mockData.expectedAvailableActivitiesNoAvailableActivitiesOutput, outContent.toString());
        
        System.setOut(System.out);
    }
}
