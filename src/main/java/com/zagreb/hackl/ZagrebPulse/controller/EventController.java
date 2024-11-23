package com.zagreb.hackl.ZagrebPulse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zagreb.hackl.ZagrebPulse.model.EventRecord;
import com.zagreb.hackl.ZagrebPulse.service.EventService;

@RestController
public class EventController {

    private final EventService eventService;
    

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // Define the endpoint that will fetch events
    @CrossOrigin(origins = {"http://localhost:4200"})
    @GetMapping("/api/events")
    public List<EventRecord> getEvents() {
        // Call the service to fetch events
        return eventService.fetchEvents(null);
    }
    @CrossOrigin(origins = {"http://localhost:4200"})
    @GetMapping("/api/events/zabava")
    public List<EventRecord> getFunEvents() {
        // Call the service to fetch events

        return eventService.fetchEvents(true);
    }
}

