package com.zagreb.hackl.ZagrebPulse.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)  // Ignore any unknown fields in the response
public class EventResponse {
    private List<EventRecord> records;

	public List<EventRecord> getRecords() {
		return records;
	}
    
    
}
