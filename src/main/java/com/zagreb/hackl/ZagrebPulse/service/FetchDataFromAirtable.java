package com.zagreb.hackl.ZagrebPulse.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zagreb.hackl.ZagrebPulse.model.*;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class FetchDataFromAirtable {

    private static final String API_URL = "https://api.airtable.com/v0/appE6L6fQPeZ6s8Gt/tblZ6EUAeNxYXP574";
    private static final String API_KEY = "pats9KvXvBmivlseG.4a3d9b8d286612bfab38436144cfda8ce68ac9d5603a7a7b43a3c0247802c538";

    public void fetchEvents() {
        try {
            // Create the URL and open a connection to the Airtable API
            URL url = new URL(API_URL);
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

            AirtableResponse airtableResponse = objectMapper.readValue(response.toString(), AirtableResponse.class);

            // Print the records
            List<AirtableRecord> records = airtableResponse.getRecords();
            for (AirtableRecord record : records) {
                System.out.println(record);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
