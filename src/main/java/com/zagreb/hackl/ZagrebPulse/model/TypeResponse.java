package com.zagreb.hackl.ZagrebPulse.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TypeResponse {
    private List<TypeRecord> records;

	public List<TypeRecord> getRecords() {
		return records;
	}

}
