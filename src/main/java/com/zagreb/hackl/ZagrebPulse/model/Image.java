package com.zagreb.hackl.ZagrebPulse.model;

import lombok.Data;

@Data
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
    public class Thumbnails {
        private Thumbnail small;
        private Thumbnail large;
        private Thumbnail full;
    }

    @Data
    public class Thumbnail {
        private String url;
        private Integer width;
        private Integer height;
    }


}

