package com.zagreb.hackl.ZagrebPulse.controller;

import com.zagreb.hackl.ZagrebPulse.model.AgeGroupRecord;
import com.zagreb.hackl.ZagrebPulse.model.DistrictRecord;
import com.zagreb.hackl.ZagrebPulse.service.AgeGroupService;
import com.zagreb.hackl.ZagrebPulse.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgeGroupController {
    private final AgeGroupService ageGroupService;

    @Autowired
    public AgeGroupController(AgeGroupService ageGroupService) {
        this.ageGroupService = ageGroupService;
    }

    // Define the endpoint that will fetch events
    @GetMapping("/api/ageGroup")
    public List<AgeGroupRecord> getAgeGroups() {
        // Call the service to fetch events
        return ageGroupService.fetchAgeGroups();
    }

}
