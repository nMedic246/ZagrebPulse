package com.zagreb.hackl.ZagrebPulse.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)  // Ignore any unknown fields in the response
public class Image {
    private String id;
    private Integer width;
    private Integer height;
    private String url;
    private String filename;
    private Integer size;
    private String type;
    private Thumbnails thumbnails;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)  // Ignore any unknown fields in the response
    public static class Thumbnails {
        private Thumbnail small;
        private Thumbnail large;
        private Thumbnail full;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)  // Ignore any unknown fields in the response
    public static class Thumbnail {
        private String url;
        private Integer width;
        private Integer height;
    }


}

