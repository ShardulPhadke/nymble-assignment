package com.adrenalineseekers.travelagency.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.adrenalineseekers.travelagency.manager.BookingManager;
import com.adrenalineseekers.travelagency.manager.BookingManagerImpl;
import com.adrenalineseekers.travelagency.manager.TravelPackageManager;
import com.adrenalineseekers.travelagency.manager.TravelPackageManagerImpl;

@Configuration
public class AppConfig {
    @Bean
    public TravelPackageManager travelPackageManager() {
        return new TravelPackageManagerImpl();
    }

    @Bean
    public BookingManager bookingManager() {
        return new BookingManagerImpl();
    }
}