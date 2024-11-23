package com.zagreb.hackl.ZagrebPulse.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class DistrictResponse {
    private List<DistrictRecord> records;

}
