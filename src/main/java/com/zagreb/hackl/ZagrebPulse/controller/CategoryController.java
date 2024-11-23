package com.zagreb.hackl.ZagrebPulse.controller;

import com.zagreb.hackl.ZagrebPulse.model.CategoryRecord;
import com.zagreb.hackl.ZagrebPulse.model.EventRecord;
import com.zagreb.hackl.ZagrebPulse.service.CategoryService;
import com.zagreb.hackl.ZagrebPulse.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Define the endpoint that will fetch events
    @GetMapping("/api/category")
    public List<CategoryRecord> getCategories() {
        // Call the service to fetch events
        return categoryService.fetchCategories();
    }
}
