package com.zagreb.hackl.ZagrebPulse.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Organizator {
	@JsonProperty("lokacija") // Location of the organizer
	private String lokacija;

	@JsonProperty("WC prilagođen osobama s invaliditetom") // WC adapted for disabled
	private Boolean wcPrilagodjenOsobamaSInvaliditetom;

	@JsonProperty("Ulaz prilagođen osobama s invaliditetom") // Entrance adapted for disabled
	private Boolean ulazPrilagodjenOsobamaSInvaliditetom;

	@JsonProperty("Eventi") // List of event IDs this organizer is linked with
	private List<String> eventi;

	@JsonProperty("Kontakt mail") // Contact email for the organizer
	private String kontaktMail;

	@JsonProperty("ime") // Name of the organizer
	private String ime;

	@JsonProperty("Logotip") // The organizer's logo details (assuming Image class is used here)
	private List<Image> logotip;

	@JsonProperty("tip") // Type field (could be a list of event types, etc.)
	private List<String> tip;

	public String getLokacija() {
		return lokacija;
	}

	public Boolean getWcPrilagodjenOsobamaSInvaliditetom() {
		return wcPrilagodjenOsobamaSInvaliditetom;
	}

	public Boolean getUlazPrilagodjenOsobamaSInvaliditetom() {
		return ulazPrilagodjenOsobamaSInvaliditetom;
	}

	public List<String> getEventi() {
		return eventi;
	}

	public String getKontaktMail() {
		return kontaktMail;
	}

	public String getIme() {
		return ime;
	}

	public List<Image> getLogotip() {
		return logotip;
	}

	public List<String> getTip() {
		return tip;
	}

}
