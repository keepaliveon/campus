package com.example.campus.controller;


import com.example.campus.common.ImageInfo;
import com.example.campus.entity.Post;
import com.example.campus.entity.Student;
import com.example.campus.service.IPostService;
import com.example.campus.service.IStudentService;
import com.example.campus.utils.UUIDUtil;
import io.minio.MinioClient;
import io.minio.Result;
import io.minio.messages.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 帖子 前端控制器
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
@RestController
@RequestMapping("/api/post")
public class PostController {

    @Resource
    private IPostService postService;

    @Value("${minio.url}")
    private String url;

    @Value("${minio.accesskey}")
    private String accessKey;

    @Value("${minio.secretkey}")
    private String secretkey;

    @Resource
    private IStudentService studentService;

    @PostMapping("group/{gid}/{openid}")
    public ResponseEntity<?> postByGroup(@PathVariable("gid") Integer gid, @RequestBody Post post, @PathVariable String openid) {
        String id = UUIDUtil.Id();
        Student student = studentService.findStudentByOpenId(openid);
        post.setId(id);
        post.setGroupId(gid);
        post.setStudentId(student.getId());
        if (postService.save(post)) {
            return new ResponseEntity<>(id, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("group/{gid}")
    public ResponseEntity<?> listByGroup(@PathVariable Integer gid) {
        return new ResponseEntity<>(postService.listByGroup(gid), HttpStatus.OK);
    }

    @GetMapping("img/{id}")
    public ResponseEntity<List<ImageInfo>> imgList(@PathVariable String id) {
        String bucket = "POST-" + id;
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


}

