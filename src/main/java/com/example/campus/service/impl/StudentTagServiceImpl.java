package com.example.campus.service.impl;

import com.example.campus.entity.StudentTag;
import com.example.campus.mapper.StudentTagMapper;
import com.example.campus.service.IStudentTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生标签 服务实现类
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
@Service
public class StudentTagServiceImpl extends ServiceImpl<StudentTagMapper, StudentTag> implements IStudentTagService {

}
