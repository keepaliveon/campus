package com.example.campus.controller;


import com.example.campus.entity.Group;
import com.example.campus.service.IGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 板块 前端控制器
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
@RestController
@RequestMapping("/api/group")
public class GroupController {

    @Resource
    private IGroupService groupService;

    @GetMapping
    public ResponseEntity<List<Group>> list() {
        return new ResponseEntity<>(groupService.list(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Group group) {
        if (groupService.save(group)) {
            return new ResponseEntity<>("创建板块成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("创建板块失败", HttpStatus.OK);
        }
    }
}

