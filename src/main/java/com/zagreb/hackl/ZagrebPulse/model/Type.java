package com.zagreb.hackl.ZagrebPulse.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Type {
    @JsonProperty("ime") // Mapping "ime" to the Java field 'ime'
    private String ime;

    @JsonProperty("Eventi") // Mapping the list of event IDs to the Java field 'eventi'
    private List<String> eventi;
}
