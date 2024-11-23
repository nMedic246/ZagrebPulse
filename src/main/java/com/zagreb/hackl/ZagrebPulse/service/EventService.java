package com.zagreb.hackl.ZagrebPulse.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zagreb.hackl.ZagrebPulse.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EventService {
	
    private final OrganizatorService organizatorService;
	private final CategoryService categoryService;
	private final TypeService typeService;
	private final AgeGroupService ageGroupService;
	DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME; // Parses "2024-11-29T19:00:00.000Z"

	@Autowired
    public EventService(OrganizatorService organizatorService, TypeService typeService, CategoryService categoryService, AgeGroupService ageGroupService) {
        this.organizatorService = organizatorService;
		this.categoryService = categoryService;
		this.typeService = typeService;
		this.ageGroupService = ageGroupService;
	}

    @Value("${airtable.api.url}")
    private String API_URL;

    @Value("${airtable.event}")
    private String EVENT_TABLE_KEY;

    @Value("${airtable.api.key}")
    private String API_KEY;
    
    public List<EventRecord> fetchEvents(Boolean filterFun) {
        try {
        	List<EventRecord> events = fetchEventsRaw();
        	List<OrganizatorRecord> organizators = organizatorService.fetchOrganizatori();
			List<CategoryRecord> categories = categoryService.fetchCategories();
			List<TypeRecord> types = typeService.fetchTypes();
			List<AgeGroupRecord> ageGroups = ageGroupService.fetchAgeGroups();


			events = events.stream().map(event -> {
        		Set<String> organizatorIds = new HashSet<String>(event.getEvent().getOrganizatorRecord());
        		List<OrganizatorRecord> eventOrganizators = organizators.stream().filter(org -> organizatorIds.contains(org.getId())).collect(Collectors.toList());
        		event.setOrganizator(eventOrganizators);

				Set<String> categoryIds = new HashSet<String>(event.getEvent().getKategorija());
				List<CategoryRecord> eventCategories = categories.stream().filter(cat -> categoryIds.contains(cat.getId())).collect(Collectors.toList());
				event.setKategorija(eventCategories);

				Set<String> typeIds = new HashSet<String>(event.getEvent().getTip());
				List<TypeRecord> eventTypes = types.stream()
						.filter(type -> typeIds.contains(type.getId()))
						.collect(Collectors.toList());
				event.setTip(eventTypes);

				Set<String> ageGroupIds = new HashSet<>(Optional.ofNullable(event.getEvent().getCiljaneDobneSkupine()).orElse(Collections.emptyList()));
				List<AgeGroupRecord> eventAgeGroups = ageGroups.stream()
						.filter(ag -> typeIds.contains(ag.getId()))
						.collect(Collectors.toList());
				event.setDobnaSkupina(eventAgeGroups);

        		return event;
        	}).sorted(Comparator.comparing(event -> {
				String dateTimeString = event.getEvent().getDatumIVrijemePocetka();
				return LocalDateTime.parse(dateTimeString, formatter); // Convert to LocalDateTime for comparison
			})).collect(Collectors.toList());


			if(filterFun != null && filterFun) {
				CategoryRecord music = categories.stream().filter(cat -> cat.getCategory().getIme().equals("Glazba")).findFirst().orElse(null);
				CategoryRecord movie = categories.stream().filter(cat -> cat.getCategory().getIme().equals("Film")).findFirst().orElse(null);
				CategoryRecord dance = categories.stream().filter(cat -> cat.getCategory().getIme().equals("Ples")).findFirst().orElse(null);
				AgeGroupRecord youngsters = ageGroups.stream().filter(ag -> ag.getAgeGroup().getIme().equals("mladi (16-29)")).findFirst().orElse(null);

				events = events.stream().filter(e -> e.getKategorija().contains(music)
						|| e.getKategorija().contains(movie)
						|| e.getKategorija().contains(dance)
						|| e.getDobnaSkupina().contains(youngsters)
				).collect(Collectors.toList());
			}
			System.out.print(events.size());
			return events;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

	private boolean filterOn(Object o, Object value){
		return o == null || o.equals(value);
	}

	private List<EventRecord> fetchEventsRaw() throws MalformedURLException, IOException, ProtocolException,
			JsonProcessingException, JsonMappingException {
		// Create the URL and open a connection to the Airtable API
		URL url = new URL(API_URL+EVENT_TABLE_KEY+"?include=organizator");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// Set the Authorization header
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Authorization", "Bearer " + API_KEY);

		// Read the response
		InputStreamReader reader = new InputStreamReader(connection.getInputStream());
		Scanner scanner = new Scanner(reader);
		StringBuilder response = new StringBuilder();
		while (scanner.hasNext()) {
		    response.append(scanner.nextLine());
		}
		scanner.close();

		// Map the response to Java objects
		ObjectMapper objectMapper = new ObjectMapper();

		EventResponse eventResponse = objectMapper.readValue(response.toString(), EventResponse.class);

		// Print the records
		return  eventResponse.getRecords();
	}
}
