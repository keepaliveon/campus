package com.example.campus.service.impl;

import com.example.campus.entity.Student;
import com.example.campus.mapper.StudentMapper;
import com.example.campus.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 学生 服务实现类
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public Student findStudentByOpenId(String openId) {
        return studentMapper.findByOpenId(openId);
    }

    @Override
    public int countPost(String sid) {
        return studentMapper.countPostById(sid).getPostCount();
    }

    @Override
    public int countCommunity(String sid) {
        return studentMapper.countCommunityById(sid).getCommunityCount();
    }
}
