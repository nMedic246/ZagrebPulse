package com.zagreb.hackl.ZagrebPulse.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zagreb.hackl.ZagrebPulse.model.CategoryRecord;
import com.zagreb.hackl.ZagrebPulse.model.CategoryResponse;
import com.zagreb.hackl.ZagrebPulse.model.DistrictRecord;
import com.zagreb.hackl.ZagrebPulse.model.DistrictResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

@Service
public class DistrictService {
    @Value("${airtable.api.url}")
    private String API_URL;

    @Value("${airtable.district}")
    private String EVENT_DISTRICT_KEY;

    @Value("${airtable.api.key}")
    private String API_KEY;



    @Cacheable(value = "districts", key = "'kljuc'")
    public List<DistrictRecord> fetchDistricts() {
        try {
            // Create the URL and open a connection to the Airtable API
            URL url = new URL(API_URL+EVENT_DISTRICT_KEY);
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

            DistrictResponse districtResponse = objectMapper.readValue(response.toString(), DistrictResponse.class);

            // Print the records
            return districtResponse.getRecords();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
