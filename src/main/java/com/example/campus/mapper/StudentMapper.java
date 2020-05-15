package com.example.campus.mapper;

import com.example.campus.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 学生 Mapper 接口
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
public interface StudentMapper extends BaseMapper<Student> {
    Student findByOpenId(String openId);

    Student countPostById(String sid);

    Student countCommunityById(String sid);
}
