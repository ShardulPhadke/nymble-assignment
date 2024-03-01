package com.naturefirst.travelagency;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.adrenalineseekers.travelagency.enums.PassengerType;
import com.adrenalineseekers.travelagency.manager.BookingManager;
import com.adrenalineseekers.travelagency.manager.BookingManagerImpl;
import com.adrenalineseekers.travelagency.model.Passenger;
import com.adrenalineseekers.travelagency.model.TravelPackage;
import com.naturefirst.travelagency.mockdata.MockData;

public class BookingManagerTest {

	private BookingManager bookingManager;
	private MockData mockData;

	@BeforeEach
    void setUp() {
        bookingManager = new BookingManagerImpl();
        mockData = new MockData();
    }

	@Test
	void testSignUpPassengerTravelPackageHappy() {
		TravelPackage mockTravelPackage = new TravelPackage("mockTravelPackage", 5, null, new ArrayList<>());
		Passenger mockPassenger = new Passenger("mockPassenger", 1, PassengerType.STANDARD);

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

		bookingManager.signUpPassengerTravelPackage(mockTravelPackage, mockPassenger);
		assertEquals(mockData.expectedSignUpPassengerTravelPackageHappyOutput, outContent.toString());

		System.setOut(System.out);
	}

	@Test
	void testSignUpPassengerTravelPackageFullCapacity() {
		TravelPackage mockTravelPackage = new TravelPackage("mockTravelPackage", 0, null, new ArrayList<>());
		Passenger mockPassenger = new Passenger("mockPassenger", 1, PassengerType.STANDARD);

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

		bookingManager.signUpPassengerTravelPackage(mockTravelPackage, mockPassenger);
		assertEquals(mockData.expectedSignUpPassengerTravelPackageFullCapacityOutput, outContent.toString());

		System.setOut(System.out);
	}
	
	@Test
	void testSignUpPassengerActivityHappy() {
		TravelPackage mockTravelPackage = mockData.mockSignUpPassengerActivityHappy();
		Passenger mockPassenger = new Passenger("mockPassenger", 1, PassengerType.STANDARD);
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

		bookingManager.signUpPassengerActivity(mockPassenger, mockTravelPackage, "mockDestination", "mockActivity");
		assertEquals(mockData.expectedSignUpPassengerActivityHappyOutput, outContent.toString());

		System.setOut(System.out);
	}

	@Test
	void testSignUpPassengerActivityFullcapacity() {
		TravelPackage mockTravelPackage = mockData.mockSignUpPassengerActivityFullCapacity();
		Passenger mockPassenger = new Passenger("mockPassenger", 1, PassengerType.STANDARD);
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

		bookingManager.signUpPassengerActivity(mockPassenger, mockTravelPackage, "mockDestination", "mockActivity");
		assertEquals(mockData.expectedSignUpPassengerActivityFullCapacityOutput, outContent.toString());

		System.setOut(System.out);
	}

	@Test 
	void testSignUpPassengerActivityInsufficentBalance() {
		TravelPackage mockTravelPackage = mockData.mockSignUpPassengerActivityHappy();
		Passenger mockPassenger = new Passenger("mockPassenger", 1, 0, PassengerType.STANDARD);
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

		bookingManager.signUpPassengerActivity(mockPassenger, mockTravelPackage, "mockDestination", "mockActivity");
		assertEquals(mockData.expectedSignUpPassengerActivityInsufficientBalanceOutput, outContent.toString());

		System.setOut(System.out);
	}

	@Test
	void testSignUpPassengerActivityIncorrectDestination() {
		TravelPackage mockTravelPackage = mockData.mockSignUpPassengerActivityHappy();
		Passenger mockPassenger = new Passenger("mockPassenger", 1, 0, PassengerType.STANDARD);
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

		bookingManager.signUpPassengerActivity(mockPassenger, mockTravelPackage, "mockDestinationWrong", "mockActivity");
		assertEquals(mockData.expectedSignUpPassengerActivityIncorrectDestinationOutput, outContent.toString());

		System.setOut(System.out);
	}

	@Test
	void testSignUpPassengerActivityIncorrectActivity() {
		TravelPackage mockTravelPackage = mockData.mockSignUpPassengerActivityHappy();
		Passenger mockPassenger = new Passenger("mockPassenger", 1, 0, PassengerType.STANDARD);
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

		bookingManager.signUpPassengerActivity(mockPassenger, mockTravelPackage, "mockDestination", "mockActivityWrong");
		assertEquals(mockData.expectedSignUpPassengerActivityIncorrectActivityOutput, outContent.toString());

		System.setOut(System.out);
	}
}
