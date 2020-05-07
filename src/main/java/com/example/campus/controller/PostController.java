package com.example.campus.controller;


import com.example.campus.entity.Community;
import com.example.campus.entity.Group;
import com.example.campus.entity.Post;
import com.example.campus.entity.PostTag;
import com.example.campus.service.*;
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

    @Resource
    private IPostTagService postTagService;

    @PostMapping("group/{gid}")
    public ResponseEntity<?> postByGroup(@PathVariable("gid") Integer gid, @RequestBody Post post) {
        post.setGroupId(gid);
        List<PostTag> postTags = new ArrayList<>();
        for (Integer tid : post.getTags()) {
            postTags.add(new PostTag(tid, post.getId()));
        }
        postTagService.saveBatch(postTags);
        if (postService.save(post)) {
            return new ResponseEntity<>("发布成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("发布失败", HttpStatus.OK);
        }
    }

    @PostMapping("community/{id}")
    public ResponseEntity<?> postByCommunity(@PathVariable("cid") Integer cid, @RequestBody Post post) {
        post.setCommunityId(cid);
        List<PostTag> postTags = new ArrayList<>();
        for (Integer tid : post.getTags()) {
            postTags.add(new PostTag(tid, post.getId()));
        }
        postTagService.saveBatch(postTags);
        if (postService.save(post)) {
            return new ResponseEntity<>("发布成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("发布失败", HttpStatus.OK);
        }
    }

    @

}

