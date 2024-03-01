package com.adrenalineseekers.travelagency.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Destination {
    private String name;
    private List<Activity> activities;
}
