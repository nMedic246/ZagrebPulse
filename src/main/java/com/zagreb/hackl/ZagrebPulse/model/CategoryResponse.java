package com.zagreb.hackl.ZagrebPulse.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)  // Ignore any unknown fields in the response
public class CategoryResponse {
    private List<CategoryRecord> records;

}
