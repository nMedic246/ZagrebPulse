package com.zagreb.hackl.ZagrebPulse.controller;

import com.zagreb.hackl.ZagrebPulse.model.EventRecord;
import com.zagreb.hackl.ZagrebPulse.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // Define the endpoint that will fetch events
    @GetMapping("/api/events")
    public List<EventRecord> getEvents() {
        // Call the service to fetch events
        return eventService.fetchEvents();
    }
}

