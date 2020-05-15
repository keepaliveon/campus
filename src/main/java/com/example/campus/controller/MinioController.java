package com.example.campus.controller;

import com.example.campus.common.ImageInfo;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@RequestMapping("/api/oss")
public class MinioController {

    @Value("${minio.url}")
    private String url;

    @Value("${minio.accesskey}")
    private String accessKey;

    @Value("${minio.secretkey}")
    private String secretkey;

    @PostMapping
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        try {
            MinioClient minioClient = new MinioClient(url, accessKey, secretkey);
            InputStream inputStream = file.getInputStream();
            String filename = file.getOriginalFilename();
            String contentType = file.getContentType();
            minioClient.putObject("campus", filename, inputStream, contentType);
            String url = minioClient.presignedGetObject("campus", filename);
            ImageInfo imageInfo = new ImageInfo(url, filename);
            return new ResponseEntity<>(imageInfo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> remove(@RequestParam("file") String name) {
        try {
            MinioClient minioClient = new MinioClient(url, accessKey, secretkey);
            minioClient.removeObject("campus", name);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("community/{id}")
    public ResponseEntity<?> communityImgUpload(@PathVariable String id, @RequestParam("file") MultipartFile file) {
        String bucket = "community-" + id;
        try {
            MinioClient minioClient = new MinioClient(url, accessKey, secretkey);
            if (!minioClient.bucketExists(bucket)) {
                minioClient.makeBucket(bucket);
            }
            InputStream inputStream = file.getInputStream();
            String filename = file.getOriginalFilename();
            String contentType = file.getContentType();
            minioClient.putObject(bucket, filename, inputStream, contentType);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("post/{id}")
    public ResponseEntity<?> postImgUpload(@PathVariable String id, @RequestParam("file") MultipartFile file) {
        String bucket = "post-" + id;
        try {
            MinioClient minioClient = new MinioClient(url, accessKey, secretkey);
            if (!minioClient.bucketExists(bucket)) {
                minioClient.makeBucket(bucket);
            }
            InputStream inputStream = file.getInputStream();
            String filename = file.getOriginalFilename();
            String contentType = file.getContentType();
            minioClient.putObject(bucket, filename, inputStream, contentType);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
