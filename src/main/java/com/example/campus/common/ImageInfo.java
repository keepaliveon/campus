package com.example.campus.common;

import lombok.Data;

@Data
public class ImageInfo {
    private String url;
    private String name;

    public ImageInfo(String url, String name) {
        this.url = url;
        this.name = name;
    }
}
