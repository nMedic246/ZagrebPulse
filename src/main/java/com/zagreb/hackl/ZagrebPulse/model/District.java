package com.zagreb.hackl.ZagrebPulse.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class District {
    @JsonProperty("Korisnici")  // Mapping the "Korisnici" field (list of IDs)
    private List<String> korisnici;

    @JsonProperty("ime")  // Mapping the "ime" field
    private String ime;
}
