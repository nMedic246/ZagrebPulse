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

	@JsonProperty("tip") // Type field (list of IDs)
	private List<TypeRecord> tip;

	@JsonProperty("kategorija") // Category field (list of IDs)
	private List<CategoryRecord> kategorija;

	@JsonProperty("ciljanaDobnaSkupina") // Category field (list of IDs)
	private List<AgeGroupRecord> dobnaSkupina;

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

	public List<CategoryRecord> getKategorija() {
		return kategorija;
	}

	public void setKategorija(List<CategoryRecord> kategorija) {
		this.kategorija = kategorija;
	}

	public List<TypeRecord> getTip() {
		return tip;
	}

	public void setTip(List<TypeRecord> tip) {
		this.tip = tip;
	}

	public List<AgeGroupRecord> getDobnaSkupina() {
		return dobnaSkupina;
	}

	public void setDobnaSkupina(List<AgeGroupRecord> dobnaSkupina) {
		this.dobnaSkupina = dobnaSkupina;
	}
}