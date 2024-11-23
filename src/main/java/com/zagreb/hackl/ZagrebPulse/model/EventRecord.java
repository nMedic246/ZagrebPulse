package com.zagreb.hackl.ZagrebPulse.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EventRecord {

	@JsonProperty("id") // Ensures the field "id" in the JSON maps to this property
	private String id;

	@JsonProperty("createdTime") // Ensures the field "createdTime" maps here
	private String createdTime;

	@JsonProperty("fields") // Maps the nested "fields" object to the fields property
	private Event event;

	@JsonProperty("organizator")
	private List<OrganizatorRecord> organizator;

	public String getId() {
		return id;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public Event getEvent() {
		return event;
	}

	public List<OrganizatorRecord> getOrganizator() {
		return organizator;
	}

	public void setOrganizator(List<OrganizatorRecord> organizator) {
		this.organizator = organizator;
	}

}