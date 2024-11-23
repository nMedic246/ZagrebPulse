package com.zagreb.hackl.ZagrebPulse.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class Event {
    private String id; // Airtable record ID

    @JsonProperty("fields")
    private Map<String, Object> fields;

    @JsonProperty("createdTime")
    private String createdTime;
}

