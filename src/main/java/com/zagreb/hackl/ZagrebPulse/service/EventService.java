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
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventService {
	
    private final OrganizatorService organizatorService;

    @Autowired
    public EventService(OrganizatorService organizatorService) {
        this.organizatorService = organizatorService;
    }

    @Value("${airtable.api.url}")
    private String API_URL;

    @Value("${airtable.event}")
    private String EVENT_TABLE_KEY;

    @Value("${airtable.api.key}")
    private String API_KEY;
    
    public List<EventRecord> fetchEvents() {
        try {
        	List<EventRecord> events = fetchEventsRaw();
        	List<OrganizatorRecord> organizators = organizatorService.fetchOrganizatori();
        	return events.stream().map(event -> {
        		Set<String> organizatorIds = new HashSet<String>(event.getEvent().getOrganizatorRecord());
        		List<OrganizatorRecord> eventOrganizators = organizators.stream().filter(org -> organizatorIds.contains(org.getId())).collect(Collectors.toList());
        		event.setOrganizator(eventOrganizators);
        		return event;
        	}).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
