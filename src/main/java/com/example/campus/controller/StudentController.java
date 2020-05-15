package com.example.campus.controller;


import com.example.campus.common.Count;
import com.example.campus.entity.Student;
import com.example.campus.service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 学生 前端控制器
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Resource
    private IStudentService studentService;

    @GetMapping("{openId}")
    public ResponseEntity<Student> findByOpenId(@PathVariable String openId) {
        Student student = studentService.findStudentByOpenId(openId);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
    }

    @PostMapping("{openId}")
    public ResponseEntity<?> save(@PathVariable String openId, @RequestBody Student student) {
        student.setOpenId(openId);
        if (studentService.saveOrUpdate(student)) {
            return new ResponseEntity<>("保存成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("保存失败", HttpStatus.OK);
        }
    }

    @GetMapping("count/{openId}")
    public ResponseEntity<?> count(@PathVariable String openId) {
        Student student = studentService.findStudentByOpenId(openId);
        int countCommunity = studentService.countCommunity(student.getId());
        int countPost = studentService.countPost(student.getId());
        Count count = new Count();
        count.setCountCommunity(countCommunity);
        count.setCountPost(countPost);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}

