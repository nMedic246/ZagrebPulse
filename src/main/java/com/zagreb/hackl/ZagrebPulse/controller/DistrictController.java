package com.zagreb.hackl.ZagrebPulse.controller;

import com.zagreb.hackl.ZagrebPulse.model.CategoryRecord;
import com.zagreb.hackl.ZagrebPulse.model.DistrictRecord;
import com.zagreb.hackl.ZagrebPulse.service.CategoryService;
import com.zagreb.hackl.ZagrebPulse.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistrictController {
    private final DistrictService districtService;

    @Autowired
    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    // Define the endpoint that will fetch events
    @GetMapping("/api/district")
    public List<DistrictRecord> getDistricts() {
        // Call the service to fetch events
        return districtService.fetchDistricts();
    }
}
