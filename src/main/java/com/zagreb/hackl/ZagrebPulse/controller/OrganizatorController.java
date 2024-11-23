package com.zagreb.hackl.ZagrebPulse.controller;

import com.zagreb.hackl.ZagrebPulse.model.EventRecord;
import com.zagreb.hackl.ZagrebPulse.model.OrganizatorRecord;
import com.zagreb.hackl.ZagrebPulse.model.OrganizatorResponse;
import com.zagreb.hackl.ZagrebPulse.service.OrganizatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrganizatorController {
    private final OrganizatorService organizatorService;

    @Autowired
    public OrganizatorController(OrganizatorService organizatorService) {
        this.organizatorService = organizatorService;
    }

    // Define the endpoint that will fetch events
    @GetMapping("/api/organizator")
    public List<OrganizatorRecord> getEvents() {
        // Call the service to fetch events
        return organizatorService.fetchOrganizatori();
    }
}
