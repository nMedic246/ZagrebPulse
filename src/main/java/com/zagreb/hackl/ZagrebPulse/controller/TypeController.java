package com.zagreb.hackl.ZagrebPulse.controller;

import com.zagreb.hackl.ZagrebPulse.model.CategoryRecord;
import com.zagreb.hackl.ZagrebPulse.model.EventRecord;
import com.zagreb.hackl.ZagrebPulse.model.TypeRecord;
import com.zagreb.hackl.ZagrebPulse.service.CategoryService;
import com.zagreb.hackl.ZagrebPulse.service.EventService;
import com.zagreb.hackl.ZagrebPulse.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeController {
    private final TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    // Define the endpoint that will fetch events
    @GetMapping("/api/type")
    public List<TypeRecord> getTypes() {
        // Call the service to fetch events
        return typeService.fetchTypes();
    }
}
