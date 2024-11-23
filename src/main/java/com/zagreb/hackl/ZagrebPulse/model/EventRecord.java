package com.zagreb.hackl.ZagrebPulse.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EventRecord {

    @JsonProperty("id")  // Ensures the field "id" in the JSON maps to this property
    private String id;

    @JsonProperty("createdTime")  // Ensures the field "createdTime" maps here
    private String createdTime;

    @JsonProperty("fields")  // Maps the nested "fields" object to the fields property
    private Event event;
}