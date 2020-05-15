package com.example.campus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Minio {
    @Value("${minio.url}")
    private String url;

    @Value("${minio.accesskey}")
    private String accessKey;

    @Value("${minio.secretkey}")
    private String secretkey;
}
