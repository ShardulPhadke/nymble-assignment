package com.adrenalineseekers.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
}
