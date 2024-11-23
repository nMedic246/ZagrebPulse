package com.zagreb.hackl.ZagrebPulse.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore any unknown fields in the response
public class Event {

	@JsonProperty("puni naziv") // Explicitly map "puni naziv" to the Java field 'puniNaziv'
	private String puniNaziv;

	@JsonProperty("opis") // Explicitly map "opis" to the Java field 'opis'
	private String opis;

	@JsonProperty("slika") // Mapping images (slika) as a list of Image objects
	private List<Image> slika;

	@JsonProperty("cijena") // Mapping "cijena" to the 'cijena' Java field
	private Double cijena;

	@JsonProperty("skraćeni naziv") // Map "skraćeni naziv" to 'skraceniNaziv'
	private String skraceniNaziv;

	@JsonProperty("puni naziv na engleskom") // Map full name in English
	private String puniNazivNaEngleskom;

	@JsonProperty("Numerirane ulaznice") // Map "numerirane ulaznice" to Java
	private Boolean numeriraneUlaznice;

	@JsonProperty("opis na engleskom") // Map "opis na engleskom" to 'opisNaEngleskom'
	private String opisNaEngleskom;

	@JsonProperty("Dostupno na hrvatskom jeziku") // Map availability to Java
	private Boolean dostupnoNaHrvatskomJeziku;

	@JsonProperty("organizator") // Mapping organizer field (list of IDs)
	private List<String> organizatorRecord;

	@JsonProperty("broj polaznika ili ulaznica") // Mapping the number of participants or tickets
	private Integer brojPolaznikaIliUlaznica;

	@JsonProperty("ciljane dobne skupine") // Target age groups
	private List<String> ciljaneDobneSkupine;

	@JsonProperty("tip") // Type field (list of IDs)
	private List<String> tip;

	@JsonProperty("kategorija") // Category field (list of IDs)
	private List<String> kategorija;

	@JsonProperty("datum i vrijeme početka") // Start date and time
	private String datumIVrijemePocetka;
	@JsonProperty("Poveznica na događaj")
	private String poveznicaNaDogadjaj;

	// Add the missing 'učestalost' field here
	@JsonProperty("učestalost")
	private List<String> ucestalost;
	// Add other fields as necessary

	public String getPuniNaziv() {
		return puniNaziv;
	}

	public String getOpis() {
		return opis;
	}

	public List<Image> getSlika() {
		return slika;
	}

	public Double getCijena() {
		return cijena;
	}

	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}

	public String getPuniNazivNaEngleskom() {
		return puniNazivNaEngleskom;
	}

	public Boolean getNumeriraneUlaznice() {
		return numeriraneUlaznice;
	}

	public String getOpisNaEngleskom() {
		return opisNaEngleskom;
	}

	public Boolean getDostupnoNaHrvatskomJeziku() {
		return dostupnoNaHrvatskomJeziku;
	}

	public List<String> getOrganizatorRecord() {
		return organizatorRecord;
	}

	public Integer getBrojPolaznikaIliUlaznica() {
		return brojPolaznikaIliUlaznica;
	}

	public List<String> getCiljaneDobneSkupine() {
		return ciljaneDobneSkupine;
	}

	public List<String> getTip() {
		return tip;
	}

	public List<String> getKategorija() {
		return kategorija;
	}

	public String getDatumIVrijemePocetka() {
		return datumIVrijemePocetka;
	}

	public String getPoveznicaNaDogadjaj() {
		return poveznicaNaDogadjaj;
	}

	public List<String> getUcestalost() {
		return ucestalost;
	}

}
