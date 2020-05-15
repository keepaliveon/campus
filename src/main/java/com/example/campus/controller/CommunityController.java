package com.example.campus.controller;


import com.example.campus.common.ImageInfo;
import com.example.campus.entity.Community;
import com.example.campus.mapper.CommunityMapper;
import com.example.campus.security.CurrentUser;
import com.example.campus.security.UserPrincipal;
import com.example.campus.service.ICommunityService;
import com.example.campus.utils.UUIDUtil;
import io.minio.MinioClient;
import io.minio.Result;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import io.minio.messages.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * 社团 前端控制器
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
@RestController
@RequestMapping("/api/community")
public class CommunityController {

    @Resource
    private ICommunityService communityService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Value("${minio.url}")
    private String url;

    @Value("${minio.accesskey}")
    private String accessKey;

    @Value("${minio.secretkey}")
    private String secretkey;

    @PostMapping
    ResponseEntity<?> create(@RequestBody Community community) {
        community.setId(UUIDUtil.SerialNum());
        community.setPassword(passwordEncoder.encode("123456"));
        if (communityService.save(community)) {
            return new ResponseEntity<>("创建成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("创建失败", HttpStatus.OK);
        }
    }

    @GetMapping
    ResponseEntity<List<Community>> list() {
        return new ResponseEntity<>(communityService.list(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    ResponseEntity<Community> find(@PathVariable String id) {
        return new ResponseEntity<>(communityService.getById(id), HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<?> update(@RequestBody Community community) {
        if (communityService.updateById(community)) {
            return new ResponseEntity<>("更新成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("更新失败", HttpStatus.OK);
        }
    }

    @DeleteMapping("{id}")
    ResponseEntity<?> delete(@PathVariable String id) {
        if (communityService.removeById(id)) {
            return new ResponseEntity<>("删除成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("删除失败", HttpStatus.OK);
        }
    }

    @GetMapping("current")
    public ResponseEntity<Community> current(@ApiIgnore @CurrentUser UserPrincipal userPrincipal) {
        Community community = communityService.getById(userPrincipal.getUsername());
        return new ResponseEntity<>(community, HttpStatus.OK);
    }

    @GetMapping("img/{id}")
    public ResponseEntity<List<ImageInfo>> imgList(@PathVariable String id) {
        String bucket = "community-" + id;
        List<ImageInfo> imageInfoList = new ArrayList<>();
        try {
            MinioClient minioClient = new MinioClient(url, accessKey, secretkey);
            Iterable<Result<Item>> results = minioClient.listObjects(bucket);
            for (Result<Item> result : results) {
                Item item = result.get();
                String name = item.objectName();
                String url = minioClient.presignedGetObject(bucket, name);
                ImageInfo imageInfo = new ImageInfo(url, name);
                imageInfoList.add(imageInfo);
            }
            return new ResponseEntity<>(imageInfoList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("delimg/{id}/{file}")
    public ResponseEntity<List<ImageInfo>> imgList(@PathVariable String id, @PathVariable String file) {
        String bucket = "community-" + id;
        try {
            MinioClient minioClient = new MinioClient(url, accessKey, secretkey);
            minioClient.removeObject(bucket, file);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {

            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

