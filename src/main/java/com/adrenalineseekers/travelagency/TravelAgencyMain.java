package com.adrenalineseekers.travelagency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.adrenalineseekers.travelagency")
public class TravelAgencyMain {

    public static void main(String[] args) {
        SpringApplication.run(TravelAgencyMain.class, args);
    }

}