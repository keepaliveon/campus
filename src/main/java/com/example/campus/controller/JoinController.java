package com.example.campus.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.campus.entity.Join;
import com.example.campus.entity.Student;
import com.example.campus.service.IJoinService;
import com.example.campus.service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 学生加入社团中间表 前端控制器
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
@RestController
@RequestMapping("/api/join")
public class JoinController {
    @Resource
    private IJoinService joinService;

    @Resource
    private IStudentService studentService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Map<String, Object> map) {
        String openId = (String) map.get("openId");
        Integer communityId = (Integer) map.get("communityId");
        Student student = studentService.findStudentByOpenId(openId);
        Join join = new Join();  //默认待审核
        join.setCommunityId(communityId);
        join.setStudentId(student.getId());
        if (joinService.save(join)) {
            return new ResponseEntity<>("申请提交成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("申请提交失败", HttpStatus.OK);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Join join) {
        UpdateWrapper<Join> updateWrapper = new UpdateWrapper<>();
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("communityId", join.getCommunityId());
        columnMap.put("student_id", join.getStudentId());
        updateWrapper.allEq(columnMap);
        if (joinService.update(join, updateWrapper)) {
            return new ResponseEntity<>("状态更新成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("状态更新失败", HttpStatus.OK);
        }
    }
}

