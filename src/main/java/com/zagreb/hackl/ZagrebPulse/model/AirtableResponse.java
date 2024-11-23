package com.zagreb.hackl.ZagrebPulse.model;

import lombok.Data;
import java.util.List;

@Data
public class AirtableResponse {
    private List<AirtableRecord> records;
}
