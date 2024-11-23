package com.zagreb.hackl.ZagrebPulse.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zagreb.hackl.ZagrebPulse.model.EventRecord;
import com.zagreb.hackl.ZagrebPulse.model.EventResponse;
import com.zagreb.hackl.ZagrebPulse.model.OrganizatorRecord;
import com.zagreb.hackl.ZagrebPulse.model.OrganizatorResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

@Service
public class OrganizatorService {
    @Value("${airtable.api.url}")
    private String API_URL;

    @Value("${airtable.organizator}")
    private String EVENT_ORGANIZATOR_KEY;

    @Value("${airtable.api.key}")
    private String API_KEY;

    public List<OrganizatorRecord> fetchOrganizatori() {
        try {
            // Create the URL and open a connection to the Airtable API
            URL url = new URL(API_URL+EVENT_ORGANIZATOR_KEY);
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

            OrganizatorResponse organizatorResponse = objectMapper.readValue(response.toString(), OrganizatorResponse.class);

            // Print the records
            return  organizatorResponse.getRecords();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
