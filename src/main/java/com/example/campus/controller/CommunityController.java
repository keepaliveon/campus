package com.example.campus.controller;


import com.example.campus.entity.Community;
import com.example.campus.mapper.CommunityMapper;
import com.example.campus.service.ICommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @PostMapping
    ResponseEntity<?> create(@RequestBody Community community) {
        if (communityService.save(community)) {
            return new ResponseEntity<>("创建成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("创建失败", HttpStatus.OK);
        }
    }
}

